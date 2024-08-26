package org.example.weatherapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.weatherapi.dto.WeatherRequest;
import org.example.weatherapi.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{
    private final WebClient.Builder webClientBuilder;
    @Override
    public WeatherResponse getWeather(WeatherRequest weatherRequest) {
        try {
            return webClientBuilder.build().get()
                    .uri("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/London,UK?key=86MZQTFLA7P8F5UV9QEBH3VYU")
                    .retrieve()
                    .bodyToMono(WeatherResponse.class).block();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
