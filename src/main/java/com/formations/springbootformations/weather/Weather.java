package com.formations.springbootformations.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private Integer cod;
    private Integer message;
    @JsonProperty(value = "cnt")
    private Integer sizeJsonElement;
    @JsonProperty(value = "list")
    private List<Forcast> forcastList;
    private Map<String, Forcast> city;


    /**************** LES GET & SET *******************/

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public List<Forcast> getForcastList() {
        return forcastList;
    }

    public void setForcastList(List<Forcast> forcastList) {
        this.forcastList = forcastList;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getSizeJsonElement() {
        return sizeJsonElement;
    }

    public void setSizeJsonElement(Integer sizeJsonElement) {
        this.sizeJsonElement = sizeJsonElement;
    }

    public Map getCity() {
        return city;
    }

    public void setCity(LinkedHashMap city) {
        this.city = city;
    }

    /*************************END************************************/

//
//    /**
//     *
//     * @param cmpt
//     * @return La température
//     */
//    public Double getTemp(int cmpt)
//    {
//        LinkedHashMap main = (LinkedHashMap)((LinkedHashMap) this.getForcastList().get(cmpt)).get("main");
//        return ((Double) main.get("temp"));
//    }
//
//    /**
//     *
//     * @return La taille de la liste
//     */
//    public Integer getSizeList(){
//        return (this.getForcastList().size());
//    }
//
//    /**
//     *
//     * @param cmpt
//     * @return La date et l'heure
//     */
//    public String getDate(int cmpt){
//        String date = (String)((LinkedHashMap) this.getForcastList().get(cmpt)).get("dt_txt");
//        return (date);
//    }
//
//    /**
//     *
//     * @param cmpt
//     * @return De type LinkedHashMap, il renvoie des descriptions météos
//     */
//    public LinkedHashMap getWeatherDescription(int cmpt)
//    {
//        ArrayList weatherDescription = (ArrayList)((LinkedHashMap) this.getForcastList().get(cmpt)).get("weather");
//        return ((LinkedHashMap) weatherDescription.get(0));
//    }
}
