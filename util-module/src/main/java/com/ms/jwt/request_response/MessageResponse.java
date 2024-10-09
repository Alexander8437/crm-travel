package com.ms.jwt.request_response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageResponse {
	private String message;
	private int statusCode;
	private String timestamp;
	private Object data;

	public MessageResponse() {
		this.timestamp =LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);;
	}

	public MessageResponse(String message, int statusCode) {
		this();
		this.message = message;
		this.statusCode = statusCode;
	}

	public MessageResponse(String message, int statusCode, Object data) {
		this(message, statusCode);
		this.data = data;
	}

	public MessageResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
