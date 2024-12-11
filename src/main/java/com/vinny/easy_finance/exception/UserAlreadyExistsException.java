package com.vinny.easy_finance.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends DomainException {
    public UserAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, "Requisição Inválida", message);
    }

}
