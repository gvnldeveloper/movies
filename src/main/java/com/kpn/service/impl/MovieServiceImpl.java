package com.kpn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpn.dao.MovieDao;
import com.kpn.dao.model.Interest;
import com.kpn.dao.model.Movie;
import com.kpn.mapper.MovieMapper;
import com.kpn.model.Genre;
import com.kpn.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@Autowired
	private MovieMapper movieMapper;

	@Override
	public List<com.kpn.model.Movie> findMovieByRuntime(int runtime) {
		List<com.kpn.model.Movie> out = new ArrayList<com.kpn.model.Movie>();
		for (com.kpn.dao.model.Movie movie : movieDao.findMovieByRuntime(runtime)) {
			out.add(movieMapper.mapInternalToExternal(movie));
		}
		return out;
	}

	@Override
	public List<com.kpn.model.Movie> findMovieByRating(float interest) {
		List<com.kpn.model.Movie> out = new ArrayList<com.kpn.model.Movie>();
		for (com.kpn.dao.model.Movie movie : movieDao.findMovieByRating(interest)) {
			out.add(movieMapper.mapInternalToExternal(movie));
		}
		return out;
	}

	@Override
	public List<com.kpn.model.Movie> findMovieByGenre(Genre genre) {
		List<com.kpn.model.Movie> out = new ArrayList<com.kpn.model.Movie>();

		for (com.kpn.dao.model.Movie movie : movieDao.findMovieByGenre("Action")) {
			out.add(movieMapper.mapInternalToExternal(movie));
		}
		return out;
	}

	@Override
	public com.kpn.dao.model.Movie save(com.kpn.model.Movie movie) {
		return movieDao.save(movieMapper.mapExternalToInternal(movie));
	}

	public List<com.kpn.dao.model.Movie> findAll() {
		return movieDao.findAll();
		
	}

	@Override
	public List<Movie> findByCriteria(Interest interest) {
		return movieDao.findByCriteria(interest);
	}
}
