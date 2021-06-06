package com.example.soni.springbootrestapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity handleEmployeeNotFound(Exception e, WebRequest webRequest){
        ResponseEntity responseEntity = new ResponseEntity(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAnyException(Exception e, WebRequest webRequest){
        ResponseEntity responseEntity = new ResponseEntity("Something went wrong, Please try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
