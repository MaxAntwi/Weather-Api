package org.example.weatherapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.weatherapi.dto.WeatherRequest;
import org.example.weatherapi.dto.WeatherResponse;
import org.example.weatherapi.exception.BadFormatRequestException;
import org.example.weatherapi.exception.WeatherApiError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
        String period = weatherRequest.getPeriod().isEmpty() ? "today" : weatherRequest.getPeriod();
        if (weatherRequest.getCity().isEmpty() || weatherRequest.getCountry().isEmpty()) {
            throw new BadFormatRequestException("Bad request check country or city", HttpStatus.BAD_REQUEST.value());
        }
        try {
            String city = weatherRequest.getCity();
            String country = weatherRequest.getCountry();
            return webClientBuilder.build().get()
                    .uri("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{city},{country}/{period}?key={apiKey}", city, country, period, apiKey)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                        return clientResponse.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new BadFormatRequestException("Bad request check country or city", HttpStatus.BAD_REQUEST.value())));
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                        return clientResponse.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new WeatherApiError("Server is down try Again Later", clientResponse.statusCode().value())));
                    })
                    .bodyToMono(WeatherResponse.class).block();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
