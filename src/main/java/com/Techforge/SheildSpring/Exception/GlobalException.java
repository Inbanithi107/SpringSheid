package com.Techforge.SheildSpring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Techforge.SheildSpring.DTO.ErrorResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(OriginException.class)
	public ResponseEntity<ErrorResponse> handleOriginException(OriginException exception){
		ErrorResponse response = new ErrorResponse(exception.getMessage(), HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.FORBIDDEN);
	}

}
