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

	public com.kpn.dao.model.Customer mapExternalToInternal(com.kpn.model.Customer customerIn) {
		LOGGER.info("Enter Map External Customer Data to Internal");
		if (customerIn == null) {
			LOGGER.info("Input Customer is Null in mapExternalToInternal");
			return null;
		}
		com.kpn.dao.model.Customer customerOut = new com.kpn.dao.model.Customer();
		customerOut.setCustomer_id(customerIn.getCustomer_id());
		if (customerIn.getInterests() != null) {
			List<com.kpn.dao.model.Interest> ineterestModel = new ArrayList<com.kpn.dao.model.Interest>();
			for (com.kpn.model.Interest interest : customerIn.getInterests()) {
				ineterestModel.add(interestMapper.mapExternalToInternal(interest));

			}
			customerOut.setInterests(ineterestModel);
		}
		customerOut.setName(customerIn.getName());
		LOGGER.info("Exit Map External Customer Data to Internal");
		return customerOut;
	}
	
	public com.kpn.model.Customer mapInternalToExternal(com.kpn.dao.model.Customer customerIn) {
		LOGGER.info("Enter Map External Customer Data to Internal");
		if (customerIn == null) {
			LOGGER.info("Input Customer is Null in mapInternalToExternal");
			return null;
		}
		
		com.kpn.model.Customer customerOut = new com.kpn.model.Customer();
		
		customerOut.setCustomer_id(customerIn.getCustomer_id());
		if (customerIn.getInterests() != null) {
			List<com.kpn.model.Interest> ineterestModel = new ArrayList<com.kpn.model.Interest>();
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
