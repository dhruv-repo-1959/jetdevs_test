package com.jetdevs.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidExcelFormat extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3445426120333931735L;

	public InvalidExcelFormat(String exception) {
		super(exception);
	}
}
