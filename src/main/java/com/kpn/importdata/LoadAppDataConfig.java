package com.kpn.importdata;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpn.model.Customer;
import com.kpn.model.Movie;
import com.kpn.model.Movies;
import com.kpn.service.CustomerService;
import com.kpn.service.MovieService;

@Configuration
public class LoadAppDataConfig {

	@Value("classpath:input/movies.xml")
	private Resource resource;

	@Autowired
	private MovieService movieService;

	@Autowired
	private CustomerService customerService;

	@Bean
	CommandLineRunner loadMovie() {
		return args -> {
			JAXBContext jaxbContext = JAXBContext.newInstance(Movies.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Movies movies = (Movies) jaxbUnmarshaller.unmarshal(resource.getFile());
			movies.getMovie().stream().forEach(movie -> {
				movieService.save(new Movie(movie.getTitle(), movie.getRating(), movie.getRuntime(), movie.getImdb(),
						movie.getActors(), movie.getGenres()));
			});
		};
	}

	@Bean
	CommandLineRunner loadCustomer() {
		return args -> {
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
			}
		};
	}

}
