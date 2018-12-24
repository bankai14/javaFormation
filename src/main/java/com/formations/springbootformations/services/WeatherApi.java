package com.formations.springbootformations.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formations.springbootformations.weather.Weather;

import java.io.IOException;

public class WeatherApi {
    public Weather getWeather(String city) throws IOException
    {
        OpenWeatherMap openWeatherMap = new OpenWeatherMap();
        ObjectMapper mapper = new ObjectMapper();
        Weather mp = mapper.readValue(openWeatherMap.getWeatherMap(city), Weather.class);

        return mp;
    }
}
