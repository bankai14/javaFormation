package com.formations.springbootformations.services;

import com.formations.springbootformations.weather.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RainDays {
    private static  final Logger logger = LoggerFactory.getLogger(RainDays.class);

    private List<String> rainDates;

    /**
     *
     * @return Uniquement les jours où il pleut
     * @throws IOException
     */
    public List<String> getRainDays() throws IOException
    {

        WeatherApi weather = new WeatherApi();

        Weather mp = weather.getWeather("Roubaix");

        this.rainDates = new ArrayList<String>();


        for (int i = 0; i  < mp.getSizeJsonElement(); i++)
            if (mp.getForcastList().get(i).getWeatherPrecision().get(0).getStateWeather().equals("Rain"))
                this.rainDates.add(mp.getForcastList().get(i).getDate());

        return this.rainDates;
    }
}
