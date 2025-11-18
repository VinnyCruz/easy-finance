package com.vinny.easy_finance.exception;

import com.vinny.easy_finance.controller.dto.error.RespostaDeErro;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@Component
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DomainExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<RespostaDeErro> handleDomainException(HttpServletRequest request, DomainException domainException) {

        var error = new RespostaDeErro();

        error.setTitle(domainException.getTitle());
        error.setDetail(domainException.getDetail());
        error.setStatus(HttpStatus.valueOf(domainException.getStatus().value()));
        error.setType(URI.create("about:blank"));
        error.setInstance(URI.create(request.getRequestURI()));

        return ResponseEntity.status(domainException.getStatus())
                .body(error);
    }

}