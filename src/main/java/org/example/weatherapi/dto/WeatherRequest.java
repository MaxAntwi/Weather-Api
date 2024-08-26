package org.example.weatherapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class WeatherRequest {
    private String address;
    private String city;
    private String country;
    private Double longitude;
    private Double latitude;
}
