package com.vivekchutke.microservice.promotion.pcforderservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PromotionDetailsNotFoundException extends RuntimeException {

    public PromotionDetailsNotFoundException(String message) {
        super(message);
    }
}
