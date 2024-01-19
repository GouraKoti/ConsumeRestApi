package com.molcon.ConsumeRestApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> httpClientErrorExceptionHandler(HttpClientErrorException.BadRequest httpClientErrorException) {
        return new ResponseEntity<String>("Url path is wrong. Check again!", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<String> httpClientErrorExceptionHandler(HttpClientErrorException.Unauthorized httpClientErrorException) {
        return new ResponseEntity<String>("Incorrect Username or Password. Try again!", HttpStatus.UNAUTHORIZED);
    }
}
