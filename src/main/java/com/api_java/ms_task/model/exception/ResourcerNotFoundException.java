package com.api_java.ms_task.model.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourcerNotFoundException extends RuntimeException {
    
    public ResourcerNotFoundException(String message) {
        super(message);
    }

}
