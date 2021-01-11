package jukebox.assignment.jukebox.controller.exceptions.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jukebox.assignment.jukebox.service.constants.DownStreamAPI;

public class ErrorResponse {

	private String timestamp;

	private int status;

	private String error;

	private String message;

	private DownStreamAPI api;

	private String path;

	public ErrorResponse(RestTemplateException ex, String path) {
		this.timestamp = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
		this.status = ex.getStatusCode().value();
		this.error = ex.getStatusCode().getReasonPhrase();
		this.message = ex.getError();
		this.api = ex.getApi();
		this.path = path;
	}
	
	public ErrorResponse(Exception ex, String message) {
		this.timestamp = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
		this.message = message;
		
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public DownStreamAPI getApi() {
		return api;
	}

	public void setApi(DownStreamAPI api) {
		this.api = api;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
