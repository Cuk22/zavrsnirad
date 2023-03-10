package com.iktpreobuka.project.controllers.util;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.project.security.Views;

public class RESTError {
	@JsonView(Views.Public.class)
	private int code;
	@JsonView(Views.Public.class)
	private String message;

	public RESTError() {
		super();
	}

	public RESTError(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}

