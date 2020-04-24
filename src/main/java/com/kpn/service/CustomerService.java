package com.kpn.service;

import java.util.List;
import java.util.Optional;

import com.kpn.dao.model.Customer;
import com.kpn.dto.response.CustomerInterest;
import com.kpn.exception.InterestNotFound;
import com.kpn.exception.UserNotFoundException;

public interface CustomerService {

	com.kpn.dao.model.Customer save(com.kpn.dto.Customer customer);

	Optional<Customer> findById(int id) throws UserNotFoundException;

	List<CustomerInterest> getInterest(String id) throws UserNotFoundException, InterestNotFound;

}
