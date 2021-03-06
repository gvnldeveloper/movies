package com.kpn.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerMapper.class);
	@Autowired
	private InterestMapper interestMapper;

	/**
	 * Mapping External Customer to Internal Customer
	 * 
	 * @param customerIn Database Customer
	 * @return com.kpn.dao.model.Customer External Customer object
	 */
	public com.kpn.dao.model.Customer mapExternalToInternal(com.kpn.dto.Customer customerIn) {
		LOGGER.info("Enter Map External Customer Data to Internal");
		if (customerIn == null) {
			LOGGER.info("Input Customer is Null in mapExternalToInternal");
			return null;
		}
		com.kpn.dao.model.Customer customerOut = new com.kpn.dao.model.Customer();
		customerOut.setCustomerId(customerIn.getCustomer_id());
		if (customerIn.getInterests() != null) {
			List<com.kpn.dao.model.Interest> ineterestModel = new ArrayList<com.kpn.dao.model.Interest>();
			for (com.kpn.dto.Interest interest : customerIn.getInterests()) {
				ineterestModel.add(interestMapper.mapExternalToInternal(interest));

			}
			customerOut.setInterests(ineterestModel);
		}
		customerOut.setName(customerIn.getName());
		LOGGER.info("Exit Map External Customer Data to Internal");
		return customerOut;
	}
	/**
	 * Mapping Internal Customer to External Customer
	 * 
	 * @param customerIn External Customer
	 * @return com.kpn.dao.model.Customer Database Customer object
	 */
	public com.kpn.dto.Customer mapInternalToExternal(com.kpn.dao.model.Customer customerIn) {
		LOGGER.info("Enter Map External Customer Data to Internal");
		if (customerIn == null) {
			LOGGER.info("Input Customer is Null in mapInternalToExternal");
			return null;
		}
		
		com.kpn.dto.Customer customerOut = new com.kpn.dto.Customer();
		
		customerOut.setCustomer_id(customerIn.getCustomerId());
		if (customerIn.getInterests() != null) {
			List<com.kpn.dto.Interest> ineterestModel = new ArrayList<com.kpn.dto.Interest>();
			for (com.kpn.dao.model.Interest interest : customerIn.getInterests()) {
				ineterestModel.add(interestMapper.mapInternalToExternal(interest));

			}
			customerOut.setInterests(ineterestModel);
		}
		customerOut.setName(customerIn.getName());
		LOGGER.info("Exit Map External Customer Data to Internal");
		return customerOut;
	}

}
