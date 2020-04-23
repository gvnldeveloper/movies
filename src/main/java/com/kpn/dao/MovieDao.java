package com.kpn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpn.dao.model.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>, MovieCustom {

}
