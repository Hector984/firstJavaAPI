package com.api.restfullapi.controller;

import com.api.restfullapi.exceptions.InvalidTitleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerController {

    //Esta linea nos indicaa que tipo de excepcion va a responder esta clase
    //Con esta clase solamente respondemos a la excepcion del tipo IllegalArgumentException
    @ExceptionHandler(value=IllegalArgumentException.class )
    private ResponseEntity<Map<String, Object>> IllegalArgumentHandler(IllegalArgumentException ex) {

        final var response = new HashMap<String, Object>();

        response.put("code", HttpStatus.BAD_REQUEST.value());
        response.put("status", HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value= InvalidTitleException.class)
    private ResponseEntity<Map<String, Object>> InvalidTitleException(InvalidTitleException ex) {

        final var response = new HashMap<String, Object>();

        response.put("code", HttpStatus.BAD_REQUEST.value());
        response.put("status", HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }
}
