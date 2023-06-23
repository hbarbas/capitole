package com.hbs.capitole.infrastructure.api.dtos;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ApiErrorDto {
    private HttpStatus status;
    private String date;
    private String code;
    private String exceptionMessage;
    private String stackTrace;

    public ApiErrorDto( HttpStatus status, String code, Throwable ex ) {
        this.status = status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status;
        this.date = OffsetDateTime.now().format( DateTimeFormatter.ISO_OFFSET_DATE_TIME );
        this.code = code == null ? "BKE0000" : code;
        this.exceptionMessage = getLocalizedMessage( ex );
        this.stackTrace = getStackTrace( ex );
    }

    private String getStackTrace( Throwable ex ) {
        return ExceptionUtils.getStackTrace( ex );
    }

    private String getLocalizedMessage( Throwable ex ) {
        return ex.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus( HttpStatus status ) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setMessageFromThrowable( Throwable ex ) {
        this.exceptionMessage = getLocalizedMessage( ex );
    }

    public void setStackFromThrowable( Throwable ex ) {
        this.stackTrace = getStackTrace( ex );
    }
}
