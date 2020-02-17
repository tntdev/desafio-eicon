package com.eicon.validation.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ConstraintViolationExceptionHandler extends ResponseEntityExceptionHandler {
	 
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> acceptNoSuchElementException(final NoSuchElementException ex) {
		  return new ResponseEntity<>("Produto não encontrado.", NOT_FOUND);
    }
	
	@ExceptionHandler(DuplicateNumeroControleException.class)
    public ResponseEntity<String> customHandleNotFound(Exception ex, WebRequest request) {

		return new ResponseEntity<>("A requisição contém um ou mais produtos com o número de controle já cadastrados.", NOT_ACCEPTABLE);

    }
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
	    Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
	    String errorMessage = "";
	    if (!violations.isEmpty()) {
	        StringBuilder builder = new StringBuilder();
	        violations.forEach(violation -> builder.append(violation.getMessage()+"\n") ); 
	        errorMessage = builder.toString();
	    } else {
	        errorMessage = "ConstraintViolationException occured.";
	    }
	    return new ResponseEntity<>(errorMessage, BAD_REQUEST);
	 }


}
