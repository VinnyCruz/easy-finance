package com.vinny.easy_finance.exception;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
public class ValidationDomainException extends DomainException {
    public ValidationDomainException(String detalhes){
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Requisicao Invalida", detalhes);
    }
}
