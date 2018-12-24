package com.formations.springbootformations.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formations.springbootformations.weather.Weather;

import java.io.IOException;

public class HottestDay {

    /**
     *
     * @return Le jour le plus chaud du résultat
     * @throws IOException
     */
    public String getHottestDay(String city) throws IOException {

        WeatherApi weather = new WeatherApi();

        Weather mp = weather.getWeather(city);


        double hottestTemp = 0;
        String hottestDate = null;

        for (int i = 0; i  < mp.getSizeJsonElement(); i++)
        {
            if ((double) mp.getForcastList().get(i).getMain().get("temp") > hottestTemp) {
                hottestTemp = (double) mp.getForcastList().get(i).getMain().get("temp");
                hottestDate = mp.getForcastList().get(i).getDate();
            }
        }
        return hottestDate;
    }
}
