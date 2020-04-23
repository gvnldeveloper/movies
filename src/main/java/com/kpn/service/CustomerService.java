package com.kpn.service;

import java.util.List;

import com.kpn.exception.InterestNotFound;
import com.kpn.exception.UserNotFoundException;
import com.kpn.model.CustomerInterest;

public interface CustomerService {

	com.kpn.dao.model.Customer save(com.kpn.model.Customer customer);

	com.kpn.dao.model.Customer findById(int id) throws UserNotFoundException;

	List<CustomerInterest> getInterest(String id) throws UserNotFoundException, InterestNotFound;

}
