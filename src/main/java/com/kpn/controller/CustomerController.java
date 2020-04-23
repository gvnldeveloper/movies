package com.kpn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpn.exception.InterestNotFound;
import com.kpn.exception.UserNotFoundException;
import com.kpn.model.response.CustomerInterest;
import com.kpn.service.CustomerService;

@RestController
@RequestMapping(path = "/v1/movie/suggestion/")
public class CustomerController {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private static final String GET_CUSTOMER_INTEREST_ENDPOINT = "customer/id/{id}";
	@Autowired
	private CustomerService customerService;

	/**
	 * End Point to find Customer Interest
	 * 
	 * @param id Customer unique identity
	 * @return ResponseEntity<List<CustomerInterest>> Customer Interest List
	 */
	@GetMapping(path = GET_CUSTOMER_INTEREST_ENDPOINT)
	public ResponseEntity<List<CustomerInterest>> getInterest(@PathVariable String id)
			throws UserNotFoundException, InterestNotFound {
		LOGGER.info("Enter Get Interest End Point");
		List<CustomerInterest> customerInterests = customerService.getInterest(id);
		LOGGER.info("Exit from Get Interest End Point");
		return new ResponseEntity<List<CustomerInterest>>(customerInterests, HttpStatus.OK);
	}

}
