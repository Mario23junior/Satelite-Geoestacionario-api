package com.projeto.satellite.GeostationarySatellite.Exceptions;

public class ReturnMessageWhenNoSavedIdFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ReturnMessageWhenNoSavedIdFound(String msg) {
		super(String.format(msg));
 	}
}
