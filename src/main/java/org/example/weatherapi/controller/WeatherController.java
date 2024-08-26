package org.example.weatherapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.weatherapi.dto.WeatherRequest;
import org.example.weatherapi.dto.WeatherResponse;
import org.example.weatherapi.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    @GetMapping("country")
    public WeatherResponse getWeatherByCountry(WeatherRequest weatherRequest) {
        return weatherService.getWeatherByCountryAndCity(weatherRequest);
    }
}
