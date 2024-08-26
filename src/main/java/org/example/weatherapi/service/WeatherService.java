package org.example.weatherapi.service;

import org.example.weatherapi.dto.WeatherRequest;
import org.example.weatherapi.dto.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeather(WeatherRequest weatherRequest);

    WeatherResponse getWeatherByCountryAndCity(WeatherRequest weatherRequest);
}
