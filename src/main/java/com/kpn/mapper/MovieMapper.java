package com.kpn.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
	private final Logger LOGGER = LoggerFactory.getLogger(MovieMapper.class);
	@Autowired
	private ActorMapper actorMapper;

	public com.kpn.dao.model.Movie mapExternalToInternal(com.kpn.dto.Movie movieIn) {
		LOGGER.info("Enter Map External Movie Data to Internal");
		if (movieIn == null) {
			LOGGER.info("Internal Movie Data is Null in ExternaltoInternal");
			return null;
		}
		com.kpn.dao.model.Movie movieOut = new com.kpn.dao.model.Movie();
		movieOut.setImdb(movieIn.getImdb());
		movieOut.setRating(movieIn.getRating());
		movieOut.setRuntime(movieIn.getRuntime());
		movieOut.setTitle(movieIn.getTitle());
		movieOut.setGenres(movieIn.getGenres());
		if (movieIn.getActors() != null) {
			List<com.kpn.dao.model.Actor> actorModel = new ArrayList<com.kpn.dao.model.Actor>();
			for (com.kpn.dto.Actor actor : movieIn.getActors()) {
				actorModel.add(actorMapper.mapExternalToInternal(actor));

			}
			movieOut.setActors(actorModel);
		}
		LOGGER.info("Exit Map Internal Movie Data to Internal");
		return movieOut;
	}

	public com.kpn.dto.Movie mapInternalToExternal(com.kpn.dao.model.Movie movieIn) {
		LOGGER.info("Enter Map Internal Movie Data to External");
		if (movieIn == null) {
			LOGGER.info("Movie Input Null in InternaltoExternal");
			return null;
		}
		com.kpn.dto.Movie movieOut = new com.kpn.dto.Movie();
		movieOut.setImdb(movieIn.getImdb());
		movieOut.setRating(movieIn.getRating());
		movieOut.setRuntime(movieIn.getRuntime());
		movieOut.setTitle(movieIn.getTitle());
		movieOut.setGenres(movieIn.getGenres());
		if (movieIn.getActors() != null) {
			List<com.kpn.dto.Actor> actorModel = new ArrayList<com.kpn.dto.Actor>();
			for (com.kpn.dao.model.Actor actor : movieIn.getActors()) {
				actorModel.add(actorMapper.mapInternalToExternal(actor));

			}
			movieOut.setActors(actorModel);
		}
		LOGGER.info("Enter Map Internal Movie Data to External");
		return movieOut;
	}

}
