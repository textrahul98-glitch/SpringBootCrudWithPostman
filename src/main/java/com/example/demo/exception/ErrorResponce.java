package com.example.demo.exception;

import java.util.Map;

public class ErrorResponce {
	
	private int status;
	private String message;
	private String timestamp;
	private Map<String,String> errors;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public ErrorResponce(int status, String message, String timestamp, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.errors = errors;
	}
	
	

}
