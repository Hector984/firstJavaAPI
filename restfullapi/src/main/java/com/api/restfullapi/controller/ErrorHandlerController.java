package com.api.restfullapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ErrorHandlerController {

    @ExceptionHandler(value=IllegalArgumentException.class )
    private ResponseEntity<Map<String, Object>> IllegalAgumentHandler(IllegalArgumentException ex) {

        final var response = new HashMap<String, Object>();

        response.put("code", HttpStatus.BAD_REQUEST.value());
        response.put("status", HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }
}
