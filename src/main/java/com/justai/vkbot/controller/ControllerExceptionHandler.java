package com.justai.vkbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNoSuchElementException(Exception exception) {
        log.error("{}: {}", exception.getClass().getName(), exception.getMessage());
        return ResponseEntity.ok(exception.getMessage());
    }

}
