package com.example.rentparking.exception.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Niste ulogovani ili nemate odgovarajuće dozvole")
public class HttpUnauthorizedException extends RuntimeException {
}
