package com.vinny.easy_finance.exception;

import org.springframework.http.HttpStatus;

public class EmailNotFoundException extends DomainException {
    public EmailNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, "Não Encontrado", message);
    }

}
