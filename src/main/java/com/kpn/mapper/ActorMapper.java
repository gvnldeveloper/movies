package com.kpn.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {
	private final Logger LOGGER = LoggerFactory.getLogger(ActorMapper.class);

	public com.kpn.dao.model.Actor mapExternalToInternal(com.kpn.model.Actor actorIn) {
		LOGGER.info("Enter Map External Actor Data to Internal");
		if (actorIn == null) {
			LOGGER.info("Input Actor is Null in mapExternalToInternal");
			return null;
		}
		com.kpn.dao.model.Actor actorOut = new com.kpn.dao.model.Actor();
		actorOut.setName(actorIn.getName());
		actorOut.setGender(actorIn.getGender());
		LOGGER.info("Exit Map External Actor Data to Internal");
		return actorOut;

	}

	public com.kpn.model.Actor mapInternalToExternal(com.kpn.dao.model.Actor actorIn) {
		LOGGER.info("Enter Map Internal Actor Data to External");
		if (actorIn == null) {
			LOGGER.info("Input Actor is Null in mapInternalToExternal");
			return null;
		}
		com.kpn.model.Actor actorOut = new com.kpn.model.Actor();
		actorOut.setName(actorIn.getName());
		actorOut.setGender(actorIn.getGender());
		LOGGER.info("Exit Map External Actor Data to Internal");
		return actorOut;
	}

}
