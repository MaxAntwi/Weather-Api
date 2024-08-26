package org.example.weatherapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadFormatRequestException.class)
    public ResponseEntity<String> handleBadFormatRequestException(BadFormatRequestException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
    }

    @ExceptionHandler(WeatherApiError.class)
    public ResponseEntity<String> handleWeatherApiException(WeatherApiError ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
    }
}
