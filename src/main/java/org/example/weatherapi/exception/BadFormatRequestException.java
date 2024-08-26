package org.example.weatherapi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class BadFormatRequestException extends RuntimeException {
    private final int statusCode;

    public BadFormatRequestException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
