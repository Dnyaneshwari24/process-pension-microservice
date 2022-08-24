package com.cognizant.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProcessPensionException extends RuntimeException{
	
	private static final long serialVersionUID = 210649836231358204L;
    private final String message;

}
