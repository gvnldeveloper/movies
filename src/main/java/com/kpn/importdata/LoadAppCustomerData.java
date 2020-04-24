package com.kpn.importdata;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpn.dto.Customer;
import com.kpn.service.CustomerService;

@Component
@Order(2)
public class LoadAppCustomerData implements CommandLineRunner {
	private final Logger LOGGER = LoggerFactory.getLogger(LoadAppCustomerData.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * Loading Customer data
	 */
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Loading Customer Data");
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
		};

		InputStream inputStream = getClass().getResourceAsStream("/input/profiles.json");
		try {
			List<Customer> customers = mapper.readValue(inputStream, typeReference);

			customers.stream().forEach(customer -> {
				customerService
						.save(new Customer(customer.getCustomer_id(), customer.getName(), customer.getInterests()));
			});
		} catch (IOException e) {
			LOGGER.error("Enter Map External Interest Data to Internal" + e);
		}
		LOGGER.info("Customer Data Complete Successfully!!");
	}
}
