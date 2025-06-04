package com.api.test.framework.exception;

@SuppressWarnings("serial")
public class TestException extends Exception {

	public TestException() {
		super();
	}

	public TestException(String message) {
		super(message);
	}

	public TestException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
