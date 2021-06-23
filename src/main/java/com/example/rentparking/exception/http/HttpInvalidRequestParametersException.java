package com.example.rentparking.exception.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Morate proslediti zahtevane parametre")
public class HttpInvalidRequestParametersException extends RuntimeException {
    public HttpInvalidRequestParametersException() {
    }

    public HttpInvalidRequestParametersException(String message) {
        super(message);
    }
}
