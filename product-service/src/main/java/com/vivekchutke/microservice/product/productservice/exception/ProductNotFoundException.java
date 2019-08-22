package com.vivekchutke.microservice.product.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    // Nicely Formatted the file
    public  ProductNotFoundException(String message) {
        super(message);
    }
    // Cleaned and merged with remote branch
}
