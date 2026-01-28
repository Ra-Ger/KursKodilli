package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private String name;
    private List<Country> countriesList;

    public Continent(String name,List<Country> countriesList) {
        this.name = name;
        this.countriesList = countriesList;
    }

    public List<Country> getCountriesList() {
        return new ArrayList<>(countriesList);
    }

    public String getName() {
        return name;
    }
}
