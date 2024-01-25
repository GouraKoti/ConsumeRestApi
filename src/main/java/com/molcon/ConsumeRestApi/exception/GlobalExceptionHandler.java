package com.molcon.ConsumeRestApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<ErrorMessage> httpClientErrorExceptionHandler(HttpClientErrorException.BadRequest httpClientErrorException) {
        ErrorMessage errorMessage = new ErrorMessage("Bad Request", "Url path is wrong. Check again!",
                HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorMessage> noResourceFoundExceptionHandler(NoResourceFoundException noResourceFoundException) {
        ErrorMessage errorMessage = new ErrorMessage("Not Found", "Url path is wrong. Check again!",
                HttpStatus.NOT_FOUND.value(), LocalDateTime.now());

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }



}
