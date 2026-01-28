package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity()
    {
        //Given
        List<Country> laurasiaCountries = new ArrayList<>(List.of(new Country("United Kingdom of Dinosaurs", new BigDecimal("1000000")),new Country("Smilodons Emirates", new BigDecimal("2000000")),new Country("Velociraptors Republic", new BigDecimal("3000000"))));
        List<Country> gondwanaCountries = new ArrayList<>(List.of(new Country("Council of Mammoths", new BigDecimal("4000000")),new Country("Mammal Asylum", new BigDecimal("5000000")),new Country("Federation of Large Carnivores", new BigDecimal("1000000"))));

        Continent laurasia = new Continent("Laurasia",laurasiaCountries);
        Continent gondwana = new Continent("Gondwana",gondwanaCountries);

        World middleJurassic = new World("Middle Jurassic",new ArrayList<>(List.of(laurasia,gondwana)));

        //Then /16
        assertEquals(new BigDecimal(16000000), middleJurassic.getPeopleQuantity());

    }
}
