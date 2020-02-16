package com.eicon.validation.exception;

public class DuplicateNumeroControleException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateNumeroControleException(String message ) {
		super(message);
	}

	public DuplicateNumeroControleException() {
		super();
	}

}
