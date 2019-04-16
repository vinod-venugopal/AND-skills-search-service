package com.anddigital.bootcamp.searchskill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SearchResultsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7146837884358643084L;

	public SearchResultsNotFoundException(String message) {
		super(message);
	}


}
