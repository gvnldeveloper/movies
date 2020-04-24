package com.kpn.importdata;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.kpn.dto.Movie;
import com.kpn.dto.Movies;
import com.kpn.service.MovieService;

@Component
@Order(1)
public class LoadAppMovieData implements CommandLineRunner {

	private final Logger LOGGER = LoggerFactory.getLogger(LoadAppMovieData.class);
	@Autowired
	private MovieService movieService;

	@Value("classpath:input/movies.xml")
	private Resource resource;
	/**
	 * Loading Movie data 
	 */
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Loading Movie Data");
		JAXBContext jaxbContext = JAXBContext.newInstance(Movies.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Movies movies = (Movies) jaxbUnmarshaller.unmarshal(resource.getFile());
		movies.getMovie().stream().forEach(movie -> {
			movieService.save(new Movie(movie.getTitle(), movie.getRating(), movie.getRuntime(), movie.getImdb(),
					movie.getActors(), movie.getGenres()));
		});
		LOGGER.info("Movie Data Complete Successfully!!");

	}

}
