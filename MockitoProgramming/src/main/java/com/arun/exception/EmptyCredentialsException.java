package com.arun.exception;

public class EmptyCredentialsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3565472381175183998L;

	public EmptyCredentialsException() {
		super("Empty Credentials");
	}
}
