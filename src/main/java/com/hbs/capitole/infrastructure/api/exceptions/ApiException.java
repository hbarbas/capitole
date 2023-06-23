package com.hbs.capitole.infrastructure.api.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String code;

    public ApiException( String code, String message, HttpStatus status ) {
        super( message );
        this.code = code;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
