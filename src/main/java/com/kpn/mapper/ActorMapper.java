package com.kpn.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {
	private final Logger LOGGER = LoggerFactory.getLogger(ActorMapper.class);

	/**
	 * Mapping External Actor to Internal Actor
	 * 
	 * @param actorIn External Actor
	 * @return com.kpn.dao.model.Actor Database Actor object
	 */
	public com.kpn.dao.model.Actor mapExternalToInternal(com.kpn.dto.Actor actorIn) {
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

	/**
	 * Mapping Internal Actor to External Actor
	 * 
	 * @param actorIn Database Actor
	 * @return com.kpn.dao.model.Actor External Actor object
	 */
	public com.kpn.dto.Actor mapInternalToExternal(com.kpn.dao.model.Actor actorIn) {
		LOGGER.info("Enter Map Internal Actor Data to External");
		if (actorIn == null) {
			LOGGER.info("Input Actor is Null in mapInternalToExternal");
			return null;
		}
		com.kpn.dto.Actor actorOut = new com.kpn.dto.Actor();
		actorOut.setName(actorIn.getName());
		actorOut.setGender(actorIn.getGender());
		LOGGER.info("Exit Map External Actor Data to Internal");
		return actorOut;
	}

}
