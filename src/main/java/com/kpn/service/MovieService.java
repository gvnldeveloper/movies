package com.kpn.service;

import java.util.List;

import com.kpn.dao.model.Interest;
import com.kpn.model.Genre;

public interface MovieService {

	public List<com.kpn.model.Movie> findMovieByRating(float rating);

	public List<com.kpn.model.Movie> findMovieByRuntime(int runtime);
	
	public List<com.kpn.model.Movie> findMovieByGenre(Genre genre);
	
	public List<com.kpn.dao.model.Movie> findAll();

	public com.kpn.dao.model.Movie save(com.kpn.model.Movie movie);
	
	public List<com.kpn.dao.model.Movie> findByCriteria(Interest interest);
}
