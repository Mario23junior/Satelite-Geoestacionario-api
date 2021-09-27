package com.projeto.satellite.GeostationarySatellite.ExceptionHandlingCuston;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.projeto.satellite.GeostationarySatellite.Exceptions.ReturnMessageWhenNoSavedIdFound;
import com.projeto.satellite.GeostationarySatellite.Exceptions.ValidatingDuplicateValues;

@RestControllerAdvice
public class ExceptionHandlingErro {
   
	@ExceptionHandler(ValidatingDuplicateValues.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErroResponse NotValueErroCuston(ValidatingDuplicateValues ex, WebRequest request) {
		ErroResponse erroReturn = new ErroResponse(
				HttpStatus.NOT_FOUND.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return erroReturn;
	}
	
	@ExceptionHandler(ReturnMessageWhenNoSavedIdFound.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErroResponse NotValueErroCuston(ReturnMessageWhenNoSavedIdFound ex, WebRequest request) {
		ErroResponse erroReturn = new ErroResponse(
				HttpStatus.BAD_REQUEST.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return erroReturn;
	}

	
	 @ExceptionHandler(Exception.class)
	 @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	 public ErroResponse ErroModelResponse(Exception ex, WebRequest request) {
		 ErroResponse erroResponse = new ErroResponse(
				 HttpStatus.INTERNAL_SERVER_ERROR.value(),
				 new Date(),
				 ex.getMessage(),
				 request.getDescription(false));
		 return erroResponse;
	 }
}
