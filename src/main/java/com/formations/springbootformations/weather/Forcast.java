package com.formations.springbootformations.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.LinkedHashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forcast {

    private Integer dt;
    private Object main;
    @JsonProperty(value = "dt_txt")
    private String date;
    @JsonProperty(value = "weather")
    private List<WeatherPrecision> weatherPrecision;

    /**************** LES GET & SET *******************/


    public Integer getDt() {
        return dt;
    }
    public LinkedHashMap getMain() {
        return (LinkedHashMap) main;
    }
    public String getDate() {
        return date;
    }
    public List<WeatherPrecision> getWeatherPrecision() {
        return weatherPrecision;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public void setMain(Object main) {
        this.main = main;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeatherPrecision(List<WeatherPrecision> weatherPrecision) {
        this.weatherPrecision = weatherPrecision;
    }


}
