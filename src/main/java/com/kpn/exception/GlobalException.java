package com.kpn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	/**
	 * GLobal Exception handling
	 * 
	 * Need to work Need to create separate exception handling methods
	 * 
	 * @param ex Exception object
	 * @return ResponseEntity<ApiErrorResponse> Return Api Error Response
	 */
	@ExceptionHandler({ UserNotFoundException.class, InterestNotFound.class })
	public final ResponseEntity<ApiErrorResponse> handleException(Exception ex) {

		if (ex instanceof UserNotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			UserNotFoundException unfe = (UserNotFoundException) ex;

			return new ResponseEntity<ApiErrorResponse>(new ApiErrorResponse(unfe.getErrorMessage()), status);
		} else if (ex instanceof InterestNotFound) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			InterestNotFound unfe = (InterestNotFound) ex;

			return new ResponseEntity<ApiErrorResponse>(new ApiErrorResponse(unfe.getErrorMessage()), status);
		} else {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity<ApiErrorResponse>(new ApiErrorResponse("Internal Server Error"), status);
		}
	}

}
