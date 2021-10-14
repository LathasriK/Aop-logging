package com.latha.creditservice.exception;

public class EmptyInputException extends RuntimeException{
    public EmptyInputException(String message){
        super(message);
    }
}
