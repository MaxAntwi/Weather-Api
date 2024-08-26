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
public class Days implements Serializable {
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
