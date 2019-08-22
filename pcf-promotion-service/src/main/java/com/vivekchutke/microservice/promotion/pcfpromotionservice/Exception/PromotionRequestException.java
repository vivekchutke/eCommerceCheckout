package com.vivekchutke.microservice.promotion.pcfpromotionservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PromotionRequestException extends RuntimeException {

    public PromotionRequestException(String message){
        super(message);
    }
}
