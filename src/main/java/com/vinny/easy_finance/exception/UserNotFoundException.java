package com.vinny.easy_finance.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, "Não Encontrado", message);
    }

}
