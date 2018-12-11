package com.formations.springbootformations.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.formations.springbootformations.weather.Weather;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class helloWorld {

    private static  final Logger logger = LoggerFactory.getLogger(helloWorld.class);

    @PostMapping("/hey")
    public String sayHello(@RequestParam("toto") String toto, @RequestBody String tata)
    {
        return ("Hello heyhey " + tata);
    }



    @GetMapping("/getWeather")
    public String getWeather(@RequestParam("city") String city)
    {
        HttpResponse<String> response = null;
        Weather[] weather = new Weather[100];

        ObjectMapper mapper = new ObjectMapper();

        try {

            //Je fais une requete
           response = Unirest.get("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&APPID=d5c41a0ac5565a5f9042778c0a29de48")
                   .header("cache-control", "no-cache")
                   .asString();


            Weather mp = mapper.readValue(response.getBody(), Weather.class);

            logger.debug(mp.getCod());

            //je récupère sous la forme d'un objet json la réponse.


            JSONObject obj = new JSONObject(response.getBody());
            Integer nb = 0;

            for (Object o : obj.getJSONArray("list")) {
                JSONObject test = (JSONObject) o;
                weather[nb].setCod((String) test.get("dt"));
               // System.out.println(test.get("dt"));
                nb++;
            }

        } catch (Exception e) {
            logger.error( e.toString());
       }
        //logger.info(weather);
        return (response.getBody());
    }
}
