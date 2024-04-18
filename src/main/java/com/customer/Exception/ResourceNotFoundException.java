package com.customer.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
