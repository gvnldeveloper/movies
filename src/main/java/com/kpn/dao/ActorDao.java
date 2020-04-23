package com.kpn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpn.dao.model.Actor;

@Repository
public interface ActorDao extends JpaRepository<Actor, Integer> {
}
