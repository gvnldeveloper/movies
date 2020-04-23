package com.kpn.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kpn.model.RuntimeSpecialSymbole;

@Component
public class InterestMapper {
	private final Logger LOGGER = LoggerFactory.getLogger(InterestMapper.class);

	public com.kpn.dao.model.Interest mapExternalToInternal(com.kpn.model.Interest interestIn) {
		LOGGER.info("Enter Map External Interest Data to Internal");
		if (interestIn == null) {
			LOGGER.info("Input Interest is Null in mapExternalToInternal");
			return null;
		}
		com.kpn.dao.model.Interest interestOut = new com.kpn.dao.model.Interest();
		interestOut.setActors(interestIn.getActors());
		interestOut.setGender(interestIn.getGender());
		interestOut.setGenres(interestIn.getGenres());

		setRatings(interestOut, interestIn);
		setRuntime(interestOut, interestIn);
		LOGGER.info("Enter Map External Interest Data to Internal");
		return interestOut;
	}

	public com.kpn.model.Interest mapInternalToExternal(com.kpn.dao.model.Interest interestIn) {
		LOGGER.info("Enter Map Internal Interest Data to External");
		if (interestIn == null) {
			LOGGER.info("Input Interest is Null in mapInternalToExternal");
			return null;
		}
		com.kpn.model.Interest interestOut = new com.kpn.model.Interest();
		interestOut.setActors(interestIn.getActors());
		interestOut.setGender(interestIn.getGender());
		interestOut.setGenres(interestIn.getGenres());
		interestOut.setRatings(interestIn.getRatings());
		interestOut.setRuntime(interestIn.getRuntime());
		LOGGER.info("Enter Map Internal Interest Data to External");
		return interestOut;
	}

	private void setRatings(com.kpn.dao.model.Interest interestOut, com.kpn.model.Interest interestIn) {
		LOGGER.info("Enter Setting Ratings Data");
		if (interestIn == null) {
			return;
		}
		String runtimeIn = interestIn.getRatings();
		if (runtimeIn != null) {

			StringBuffer num = new StringBuffer();
			for (int i = 0; i < runtimeIn.length(); i++) {
				if (Character.isDigit(runtimeIn.charAt(i)))
					num.append(runtimeIn.charAt(i));
				if (runtimeIn.charAt(i) == '+')
					interestOut.setRatingsWithPlus(true);

			}
			interestOut.setRatings("" + num);
		}
		LOGGER.info("Exit Setting Ratings Data");
	}

	private void setRuntime(com.kpn.dao.model.Interest interestOut, com.kpn.model.Interest interestIn) {
		LOGGER.info("Enter Setting Runtime Data");
		if (interestIn == null) {
			return;
		}
		String runtimeIn = interestIn.getRuntime();
		if (runtimeIn != null) {
			StringBuffer num = new StringBuffer();
			for (int i = 0; i < runtimeIn.length(); i++) {
				if (Character.isDigit(runtimeIn.charAt(i)))
					num.append(runtimeIn.charAt(i));
				if (runtimeIn.charAt(i) == '<')
					interestOut.setRuntimeSpecialSymbole(RuntimeSpecialSymbole.LESS_THEN);
				else if (runtimeIn.charAt(i) == '>')
					interestOut.setRuntimeSpecialSymbole(RuntimeSpecialSymbole.GREATER_THAN);
				else if (runtimeIn.charAt(i) == '=')
					interestOut.setRuntimeSpecialSymbole(RuntimeSpecialSymbole.EQUALS);
			}
			interestOut.setRuntime("" + num);

		}
		LOGGER.info("Exit Setting Runtime Data");
	}

}
