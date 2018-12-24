package com.formations.springbootformations.services;

import com.formations.springbootformations.controllers.HelloWorld;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenWeatherMap {

    private static  final Logger logger = LoggerFactory.getLogger(HelloWorld.class);


    public String getWeatherMap(String city)
    {
        HttpResponse<String> response = null;

        try {

            //Je fais une requete
            response = Unirest.get("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&APPID=d5c41a0ac5565a5f9042778c0a29de48")
                    .header("cache-control", "no-cache")
                    .asString();

        } catch (Exception e) {
            logger.error( e.toString());
            return (e.toString());
        }
        return (response.getBody());
    }
}
