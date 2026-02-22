package com.kodilla.good.patterns.challenges.flyingSymulator;

import java.util.List;

public class FlightDTO {
    String information;
    List<Flight> directConnections;
    List<List<Flight>> connectingFlights;

    public FlightDTO(String information, List<Flight> directConnections, List<List<Flight>> connectingFlights) {
        this.information = information;
        this.directConnections = directConnections;
        this.connectingFlights = connectingFlights;
    }

    public String getInformation() {
        return information;
    }

    public List<Flight> getDirectConnections() {
        return directConnections;
    }

    public List<List<Flight>> getConnectingFlights() {
        return connectingFlights;
    }
}
