package com.kpn.dao;

import com.kpn.dao.model.Interest;
import com.kpn.dao.model.Movie;
import com.kpn.model.RuntimeSpecialSymbole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieCustomImpl implements MovieCustom {
	private final Logger LOGGER = LoggerFactory.getLogger(MovieCustomImpl.class);
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Movie> findByCriteria(Interest interest) {
		LOGGER.info("Enter findByCriteria");
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> movie = cq.from(Movie.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		// checking if parameter name is provided, if yes, adding new predicate
		if (interest.getRatings() != null) {
			if (interest.isRatingsWithPlus())
				predicates.add(cb.greaterThan(movie.get("rating"), Float.parseFloat(interest.getRatings())));
			else
				predicates.add(cb.equal(movie.get("rating"), Float.parseFloat(interest.getRatings())));
		}

		if (interest.getRuntime() != null) {
			if (interest.getRuntimeSpecialSymbole().equals(RuntimeSpecialSymbole.GREATER_THAN))
				predicates.add(cb.greaterThan(movie.get("runtime"), Integer.parseInt(interest.getRuntime())));
			else if (interest.getRuntimeSpecialSymbole().equals(RuntimeSpecialSymbole.EQUALS))
				predicates.add(cb.equal(movie.get("runtime"), Integer.parseInt(interest.getRuntime())));
			else if (interest.getRuntimeSpecialSymbole().equals(RuntimeSpecialSymbole.LESS_THEN))
				predicates.add(cb.lessThan(movie.get("runtime"), Integer.parseInt(interest.getRuntime())));
		}

		if (interest.getGenres() != null) {
			predicates.add(cb.isMember(interest.getGenres(), movie.get("genres")));

		}
		if (interest.getActors() != null) {
			predicates.add(cb.isMember(interest.getActors(), movie.get("actors").get("name")));

		}

		if (interest.getGender() != null) {
			predicates.add(cb.isMember(interest.getGender(), movie.get("actors").get("gender")));

		}

		
		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<Movie> query = entityManager.createQuery(cq);
		List<Movie> items = query.getResultList();
		LOGGER.info("Exit findByCriteria");
		return items;
	}
}
