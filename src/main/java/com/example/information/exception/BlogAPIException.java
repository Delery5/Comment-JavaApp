package com.example.information.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;
	public BlogAPIException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlogAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public BlogAPIException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}
	
	
	
}
