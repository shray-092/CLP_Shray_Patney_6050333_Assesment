package com.example.demo.exception;

public class ErrorResponse {
	private String error;
	private String message;
	private Object timestamp;

	public ErrorResponse(String error, String message, Object timestamp) {
		this.error = error;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Object timestamp) {
		this.timestamp = timestamp;
	}

}
