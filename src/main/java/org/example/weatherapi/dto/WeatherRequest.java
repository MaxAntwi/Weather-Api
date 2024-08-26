package org.example.weatherapi.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class WeatherRequest {
    private String address;
    private String city;
    private String country;
    private Double longitude;
    private Double latitude;
    private String period = "";
}
