package com.kpn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpn.dao.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
