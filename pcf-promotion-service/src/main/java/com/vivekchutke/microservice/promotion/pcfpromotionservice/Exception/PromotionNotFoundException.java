package com.vivekchutke.microservice.promotion.pcfpromotionservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PromotionNotFoundException extends RuntimeException {

    public PromotionNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
