package com.vinny.easy_finance.exception;

import org.springframework.http.HttpStatus;

public class AdminAlreadyExistsDomainException extends DomainException {
    public AdminAlreadyExistsDomainException(String message) {
        super(HttpStatus.CONFLICT, "Requisição Inválida", message);
    }

}
