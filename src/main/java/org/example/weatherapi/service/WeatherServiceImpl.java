package org.example.weatherapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.weatherapi.dto.WeatherRequest;
import org.example.weatherapi.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{
    private final WebClient.Builder webClientBuilder;
    private final String apiKey = System.getenv("API_KEY");

    @Override
    public WeatherResponse getWeather(WeatherRequest weatherRequest) {
        try {
            return webClientBuilder.build().get()
                    .uri("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/London,UK?key={apiKey}",apiKey)
                    .retrieve()
                    .bodyToMono(WeatherResponse.class).block();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public WeatherResponse getWeatherByCountryAndCity(WeatherRequest weatherRequest) {
        if (weatherRequest.getCity().isEmpty() || weatherRequest.getCountry().isEmpty()) {
            return null;
        }
        try {
            String city = weatherRequest.getCity();
            String country = weatherRequest.getCountry();
            return webClientBuilder.build().get()
                    .uri("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{city},{country}?key={apiKey}", city, country, apiKey)
                    .retrieve()
                    .bodyToMono(WeatherResponse.class).block();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
