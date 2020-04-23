package com.kpn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kpn.dao.model.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>, MovieCustom {

	@Query("SELECT mov FROM Movie mov  WHERE  mov.rating >= :rating")
	public List<Movie> findMovieByRating(float rating);

	@Query("SELECT  mov FROM Movie mov  WHERE mov.runtime >= :runtime")
	public List<Movie> findMovieByRuntime(int runtime);

	@Query(nativeQuery = true, value = "SELECT * FROM MOVIE m join MOVIE_GENRE_MAP mp on m.MOVIE_ID  = mp.MOVIE_ID)")
	public List<Movie> findMovieByGenre(String genre);

}
