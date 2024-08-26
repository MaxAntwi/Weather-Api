package org.example.weatherapi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class WeatherApiError extends RuntimeException {
    private final int statusCode;

    public WeatherApiError(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
