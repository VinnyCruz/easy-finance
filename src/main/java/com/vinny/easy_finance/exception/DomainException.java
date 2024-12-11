package com.vinny.easy_finance.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class DomainException extends RuntimeException {

    private final HttpStatus status;
    private final String title;
    private final String detail;

    protected DomainException(HttpStatus status, String title, String detail) {
        this.status = status;
        this.title = title;
        this.detail = detail;
    }
}
