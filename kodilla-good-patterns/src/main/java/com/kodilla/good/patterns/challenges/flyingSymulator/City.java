package com.kodilla.good.patterns.challenges.flyingSymulator;

import java.util.Objects;

public class City {
    private final String name;

    public City(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
