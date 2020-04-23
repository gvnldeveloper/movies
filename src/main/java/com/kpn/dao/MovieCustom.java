package com.kpn.dao;

import java.util.List;

import com.kpn.dao.model.Interest;
import com.kpn.dao.model.Movie;

public interface MovieCustom {
	public List<Movie> findByCriteria(Interest interest);
}
