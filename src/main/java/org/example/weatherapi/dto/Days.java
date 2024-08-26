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
public class Days {
    private String dateTime;
    private String dateTimeEpoch;
    private String conditions;
    private String description;
    private String icon;
    private String visibility;
    private String sunrise;
    private String sunset;
    private List<String> preciptype ;
}
