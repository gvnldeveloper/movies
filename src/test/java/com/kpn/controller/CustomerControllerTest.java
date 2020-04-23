package com.kpn.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MimeTypeUtils;

import com.kpn.model.response.CustomerInterest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest extends AbstractControllerTest {
	@Autowired
	protected MockMvc mockMvc;
	private static final String GET_CUSTOMER_INTEREST_ENDPOINT = "/v1/movie/suggestion/customer/id/";

	@Test
	public void testGetInterestFlow() throws Exception {

		final MvcResult result = mockMvc
				.perform(get(GET_CUSTOMER_INTEREST_ENDPOINT + "1002").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andReturn();

		List<CustomerInterest> actualResponse = deSerializeObject(result.getResponse().getContentAsString());
		Assert.assertEquals(3, actualResponse.size());

	}

	@Test
	public void testGetInterestFlow_Imdb() throws Exception {

		final MvcResult result = mockMvc
				.perform(get(GET_CUSTOMER_INTEREST_ENDPOINT + "1002").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andReturn();

		List<CustomerInterest> actualResponse = deSerializeObject(result.getResponse().getContentAsString());
		Assert.assertTrue(actualResponse.get(0).getImdb().equals("https://www.imdb.com/title/tt0462499"));

	}

	@Test
	public void testGetInterestFlow_Rating() throws Exception {

		final MvcResult result = mockMvc
				.perform(get(GET_CUSTOMER_INTEREST_ENDPOINT + "1002").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andReturn();

		List<CustomerInterest> actualResponse = deSerializeObject(result.getResponse().getContentAsString());
		Assert.assertTrue(actualResponse.get(0).getTitle().equals("Rambo"));

	}

}
