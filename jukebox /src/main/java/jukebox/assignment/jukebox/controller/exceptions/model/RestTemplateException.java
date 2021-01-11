package jukebox.assignment.jukebox.controller.exceptions.model;

import org.springframework.http.HttpStatus;

import jukebox.assignment.jukebox.service.constants.DownStreamAPI;

public class RestTemplateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private DownStreamAPI api;
	private HttpStatus statusCode;
	private String error;

	public RestTemplateException(DownStreamAPI api, HttpStatus statusCode, String error) {
		super(error);
		this.statusCode = statusCode;
		this.error = error;
		this.api = api;
	}

	public RestTemplateException(HttpStatus statusCode, String error) {
		super(error);
		this.statusCode = statusCode;
		this.error = error;
	}

	public DownStreamAPI getApi() {
		return api;
	}

	public void setApi(DownStreamAPI api) {
		this.api = api;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
