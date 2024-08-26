package org.example.weatherapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class WeatherResponse {
    private Long queryCost;
    private Long latitude;
    private Long longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private String description;
    private List<Days> days;
}
