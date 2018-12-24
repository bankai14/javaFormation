package com.formations.springbootformations.weather;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherPrecision {

    @JsonProperty(value = "main")
    private String stateWeather;
    @JsonProperty(value = "description")
    private String descriptionStateWeather;

    public String getStateWeather() {
        return stateWeather;
    }
    public String getDescriptionStateWeather() {
        return descriptionStateWeather;
    }
}