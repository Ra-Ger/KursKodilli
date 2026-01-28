package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World implements PeopleStorage{

    private String name;
    private List<Continent> continentsList;

    public World(String name,List<Continent> continentsList) {
        this.name = name;
        this.continentsList = continentsList;
    }

    public String getName()
    {
        return  name;
    }

    public List<Continent> getContinentsList() {
        return new ArrayList<>(continentsList);
    }

    public BigDecimal getPeopleQuantity()
    {
        BigDecimal totalPeople = continentsList.stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return totalPeople;
    }
}
