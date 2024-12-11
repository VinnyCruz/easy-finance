package com.vinny.easy_finance.exception;

import org.springframework.http.HttpStatus;

public class InvalidJWTAuthenticationException extends DomainException {
    public InvalidJWTAuthenticationException(String message) {
        super(HttpStatus.FORBIDDEN, "Proibido", message);
    }

}
