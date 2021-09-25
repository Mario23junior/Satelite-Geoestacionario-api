package com.projeto.satellite.GeostationarySatellite.Exceptions;

public class ValidatingDuplicateValues extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValidatingDuplicateValues(String msg) {
		super(String.format(msg));
 	}
}
