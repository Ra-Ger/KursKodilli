package com.kodilla.good.patterns.challenges.flyingSymulator;

import java.util.List;

public class FlightDTO {
    String information;
    List<Flight> flightsFrom;
    List<Flight> flightsTo;
    List<List<Flight>> flightsVia;

    public FlightDTO(String information, List<Flight> flightsFrom, List<List<Flight>> flightsVia, List<Flight> flightsTo) {
        this.information = information;
        this.flightsFrom = flightsFrom;
        this.flightsTo = flightsTo;
        this.flightsVia = flightsVia;
    }

    public String getInformation() {
        return information;
    }

    public List<Flight> getFlightsFrom() {
        return flightsFrom;
    }

    public List<Flight> getFlightsTo() {
        return flightsTo;
    }

    public List<List<Flight>> getFlightsVia() {
        return flightsVia;
    }
}
