package com.kpn.exception;

/**
 * 
 * Class for sending global error response message
 * 
 */
public class ApiErrorResponse {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiErrorResponse(String message) {
		super();
		this.message = message;
	}

	
	public ApiErrorResponse() {
		super();
	}

	@Override
	public String toString() {
		return "ApiErrorResponse [message=" + message + "]";
	}
	
	
	

}
