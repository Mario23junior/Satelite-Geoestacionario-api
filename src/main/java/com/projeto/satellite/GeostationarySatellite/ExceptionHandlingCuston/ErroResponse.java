package com.projeto.satellite.GeostationarySatellite.ExceptionHandlingCuston;

import java.util.Date;

public class ErroResponse {

	private int id;
	private Date timestamp;
	private String message;
	private String path;

	public ErroResponse(int i ,Date timestamp, String message, String path) {
		super();
		this.id = i;
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
	}

	public Integer getId() {
		return id;
	}

	public void Integer(Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
