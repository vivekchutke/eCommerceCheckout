package com.vivekchutke.microservice.product.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public  ProductNotFoundException(String message) {

        super(message);
    }

    // Addint this changes and comiting them to see if it flows to git


    // Adding another line and this should not be in GitHub
}
