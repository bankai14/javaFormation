package com.formations.springbootformations.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formations.springbootformations.weather.Weather;

import java.io.IOException;

public class HottestDay {

    public String getHottestDay() throws IOException {
        OpenWeatherMap openWeatherMap = new OpenWeatherMap();
        ObjectMapper mapper = new ObjectMapper();
        Weather mp = mapper.readValue(openWeatherMap.getWeatherMap("Roubaix"), Weather.class);

        //System.out.println(mp.getForcastList().get(0).toString());

        return "ret";
    }
}
