package com.formations.springbootformations.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forcast {

    private Integer dt;
    private ArrayList main;

    /**************** LES GET & SET *******************/


    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }


    public ArrayList getMain() {
        return main;
    }

    public void setMain(ArrayList main) {
        this.main = main;
    }
}
