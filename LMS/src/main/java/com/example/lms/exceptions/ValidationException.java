package com.example.lms.exceptions;

public class ValidationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1938206456754861279L;

	public ValidationException(String str) {
		super(str);
	}

}
