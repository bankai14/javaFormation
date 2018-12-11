package com.formations.springbootformations.weather;

import org.omg.CORBA.Any;

import java.util.ArrayList;

public class Weather {

    private String cod;
    private Integer message;
    private Integer cnt;
    private ArrayList list;
    private Any city;


    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public Any getCity() {
        return city;
    }

    public void setCity(Any city) {
        this.city = city;
    }
}
