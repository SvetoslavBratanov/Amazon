package com.amazon.exception;

public class InvalidInfoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1489024641645768504L;

	public InvalidInfoException() {
		super();
	}

	public InvalidInfoException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidInfoException(String message) {
		super(message);
	}

}
