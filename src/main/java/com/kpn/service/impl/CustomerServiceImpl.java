package com.kpn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpn.dao.CustomerDao;
import com.kpn.dao.model.Actor;
import com.kpn.exception.InterestNotFound;
import com.kpn.exception.UserNotFoundException;
import com.kpn.mapper.CustomerMapper;
import com.kpn.mapper.InterestMapper;
import com.kpn.model.CustomerInterest;
import com.kpn.model.Genre;
import com.kpn.model.RuntimeSpecialSymbole;
import com.kpn.service.CustomerService;
import com.kpn.service.MovieService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	InterestMapper mapper;

	@Autowired
	MovieService movieService;

	@Override
	public com.kpn.dao.model.Customer save(com.kpn.model.Customer customer) {
		LOGGER.info("Save Customer");
		return customerDao.save(customerMapper.mapExternalToInternal(customer));
	}

	@Override
	public com.kpn.dao.model.Customer findById(int id) throws UserNotFoundException {
		LOGGER.info("Fetch Customer using ID:  {}", id);
		try {
			return customerDao.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new UserNotFoundException("Customer Not Found");
		}

	}

	@Override
	public List<CustomerInterest> getInterest(String id) throws UserNotFoundException, InterestNotFound {
		LOGGER.info("Enter Get Interest in CustomerService {}", id);
		List<CustomerInterest> customerInterest = new ArrayList<CustomerInterest>();
		com.kpn.dao.model.Customer customer = findById(Integer.parseInt(id));
		if (customer != null) {
			List<com.kpn.dao.model.Interest> interests = customer.getInterests();
			if (interests != null && !interests.isEmpty()) {
				com.kpn.dao.model.Interest inter = interests.get(0);
				List<com.kpn.dao.model.Movie> out = movieService.findAll();

				out.stream().distinct().forEach(movie -> {
					if (inter.getRatings() != null) {
						if (inter.getRatings().equals("" + movie.getRating()) && inter.isRatingsWithPlus()) {
							customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
							return;
						} else if (inter.getRatings().equals("" + movie.getRating())) {
							customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
							return;
						}

					}

					if (inter.getRuntime() != null) {
						if (inter.getRuntimeSpecialSymbole().equals(RuntimeSpecialSymbole.EQUALS)
								&& Integer.parseInt(inter.getRuntime()) == movie.getRuntime()) {
							customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
							return;
						} else if (inter.getRuntimeSpecialSymbole().equals(RuntimeSpecialSymbole.GREATER_THAN)
								&& Integer.parseInt(inter.getRuntime()) > movie.getRuntime()) {
							customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
							return;
						} else if (inter.getRuntimeSpecialSymbole().equals(RuntimeSpecialSymbole.LESS_THEN)
								&& movie.getRuntime() < Integer.parseInt(inter.getRuntime())) {
							customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
							return;
						}
					}

					if (inter.getGender() != null && !movie.getActors().isEmpty()) {
						for (Actor actor : movie.getActors()) {
							if (inter.getGender().equals(actor.getGender())) {
								customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
								return;
							}
						}

					}

					if (inter.getGenres() != null) {

						for (Genre genre : movie.getGenres()) {
							if (inter.getGenres().equals(genre)) {
								customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
								return;
							}
						}

					}

					if (inter.getActors() != null && !inter.getActors().isEmpty()) {
						for (Actor actor : movie.getActors()) {
							if (inter.getActors().equals(actor.getName())) {
								customerInterest.add(new CustomerInterest(movie.getTitle(), movie.getImdb()));
								return;
							}
						}
					}
				});
			} else {
				throw new InterestNotFound("Customer Interest Not Available");
			}
		} else {
			throw new UserNotFoundException("Customer Not Found");
		}
		LOGGER.info("Exit Get Interest in CustomerService {}", customerInterest);
		return customerInterest;
	}

	/*
	 * 
	 * 
	 * @Override public List<CustomerInterest> getInterest(String id) throws
	 * UserNotFoundException, InterestNotFound {
	 * LOGGER.info("Enter Get Interest in CustomerService {}", id);
	 * List<CustomerInterest> customerInterest = new ArrayList<CustomerInterest>();
	 * com.kpn.dao.model.Customer customer = findById(Integer.parseInt(id)); if
	 * (customer != null) { List<com.kpn.dao.model.Interest> interests =
	 * customer.getInterests(); if (interests != null && !interests.isEmpty()) {
	 * List<Movie> output = movieService.findByCriteria(interests.get(0));
	 * LOGGER.info("Interest Output {}", output); } else { throw new
	 * InterestNotFound("Customer Interest Not Available"); } } else { throw new
	 * UserNotFoundException("Customer Not Found"); }
	 * LOGGER.info("Exit Get Interest in CustomerService {}", customerInterest);
	 * return customerInterest; }
	 * 
	 */

}
