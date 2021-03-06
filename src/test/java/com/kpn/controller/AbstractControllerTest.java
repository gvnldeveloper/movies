package com.kpn.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpn.dto.response.CustomerInterest;

public abstract class AbstractControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	protected MockHttpServletResponse performGetRequest(String url, String requestParam) throws Exception {
		MvcResult result = this.mockMvc.perform(get(url).contentType(APPLICATION_JSON).param(requestParam))
				// .andDo(print())
				.andReturn();

		return result.getResponse();
	}

	protected byte[] serializeObject(Object request) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsBytes(request);
	}

	protected List<CustomerInterest> deSerializeObject(String responseData) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(responseData, new TypeReference<List<CustomerInterest>>() {
		});
	}

}
