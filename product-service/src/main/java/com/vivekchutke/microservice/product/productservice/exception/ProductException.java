package com.vivekchutke.microservice.product.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProductException  extends RuntimeException {

    public ProductException(){
        super("Sorry, There was an exception processing your request");
    }
}
