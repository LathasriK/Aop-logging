package com.latha.creditservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


    //    handle specific
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<?> handleAPIException(EmptyInputException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Date(), 400, exception.getMessage(), "BadRequest");

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

}