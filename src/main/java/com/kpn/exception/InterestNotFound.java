package com.kpn.exception;

public class InterestNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	/**
	 * @return errorMessage of String Type
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage type set into errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public InterestNotFound() {
		super();
	}

	/**
	 * @param errorMessage
	 * @description
	 */
	public InterestNotFound(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}