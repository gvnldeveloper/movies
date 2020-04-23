package com.kpn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpn.dao.model.Interest;

@Repository
public interface InterestDao extends JpaRepository<Interest, Integer> {

}
