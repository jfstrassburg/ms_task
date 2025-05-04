package com.api_java.ms_task.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api_java.ms_task.model.error.ErrorMessage;
import com.api_java.ms_task.model.exception.ResourcerNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourcerNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourcerNotFoundException ex) {

        ErrorMessage error = new ErrorMessage("Recurso não encontrado", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
