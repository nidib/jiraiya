package com.nidib.jiraiya.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject<T> {
	private final String message;
	private T content;

	public ResponseObject(String message) {
		this.message = message;
	}

	public ResponseObject(String message, T content) {
		this.content = content;
		this.message = message;
	}
}
