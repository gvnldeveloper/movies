package com.kpn.service;

import java.util.List;

import com.kpn.dao.model.Interest;

public interface MovieService {

	public List<com.kpn.dao.model.Movie> findAll();

	public com.kpn.dao.model.Movie save(com.kpn.model.Movie movie);

	public List<com.kpn.dao.model.Movie> findByCriteria(Interest interest);
}
