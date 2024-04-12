package com.hackathon.travelmap.common.exception.custom;

import com.hackathon.travelmap.common.Constants;
import org.springframework.http.HttpStatus;


public class NotFoundException extends Exception {
    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public NotFoundException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
