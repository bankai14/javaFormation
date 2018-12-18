package com.formations.springbootformations.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.formations.springbootformations.weather.Weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HelloWorld {

    private static  final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @PostMapping("/hey")
    public String sayHello(@RequestParam("toto") String toto, @RequestBody String tata)
    {
        return ("Hello heyhey " + tata);
    }



    @GetMapping("/getWeather")
    public String getWeather(@RequestParam("city") String city)
    {
        HttpResponse<String> response = null;
        //Weather[] weather = new Weather[100];

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        try {

            //Je fais une requete
           response = Unirest.get("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&APPID=d5c41a0ac5565a5f9042778c0a29de48")
                   .header("cache-control", "no-cache")
                   .asString();

          /* for (Integer iterate = 0; iterate < 20; iterate++)
           {
               System.out.println(this.parseTemp(response.getBody(), iterate));
           }*/

           //Autre méthode

            Weather mp = mapper.readValue(response.getBody(), Weather.class);

          /* map = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>(){});

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println("key : " + entry.getKey());
                System.out.println("value type : " + entry.getValue().getClass());
                System.out.println("value : " + entry.getValue().toString());
            }*/
            //logger.debug(mp.getForcastList());

           // LinkedHashMap testing = (LinkedHashMap)((LinkedHashMap) mp.getForcastList().get(1)).get("weather");

           // System.out.println(mp.getTemp(1));

            System.out.println(mp.getForcastList().get(0));

            //je récupère sous la forme d'un objet json la réponse.


            JSONObject obj = new JSONObject(response.getBody());
            Integer nb = 0;

            for (Object o : obj.getJSONArray("list")) {
                JSONObject test = (JSONObject) o;
                //weather[nb].setCod((String) test.get("dt"));
                //System.out.println(test.get("main").getClass());
                nb++;
            }

        } catch (Exception e) {
            logger.error( e.toString());
       }
        //logger.info(weather);
        return (response.getBody());
    }

    public Double parseTemp(String jsonLine, Integer iterate){
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();

        JsonArray jarray = jobject.getAsJsonArray("list");
        jobject = jarray.get(iterate).getAsJsonObject();

        Double result = jobject.get("main").getAsJsonObject().get("temp").getAsDouble();
        return result;
    }

}
