package org.example.weatherapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@JsonSerialize
public class WeatherResponse implements Serializable {
    private Long queryCost;
    private Long latitude;
    private Long longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private String description;
    private List<Days> days;
}
