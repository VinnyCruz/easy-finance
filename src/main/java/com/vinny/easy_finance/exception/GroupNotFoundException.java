package com.vinny.easy_finance.exception;

import org.springframework.http.HttpStatus;

public class GroupNotFoundException extends DomainException {
    public GroupNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, "Não Encontrado", message);
    }

}
