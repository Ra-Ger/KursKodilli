package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {

    private Map<String, Boolean> availableAirports = new HashMap<>();

    public FlightSearchEngine(Map<String,Boolean> availableAirports)
    {
        this.availableAirports = availableAirports;
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException
    {
        boolean arrivalAirportAvailable = false;
        boolean departureAirportAvailable = false;

        if(availableAirports.containsKey(flight.getArrivalAirport()))
        {
            arrivalAirportAvailable = availableAirports.get(flight.getArrivalAirport());
        }
        else throw new RouteNotFoundException("Arrival airport not found.");

        if(availableAirports.containsKey(flight.getDepartureAirport()))
        {
            departureAirportAvailable = availableAirports.get(flight.getDepartureAirport());
        }
        else throw new RouteNotFoundException("Departure airport not found.");

        return departureAirportAvailable && arrivalAirportAvailable;
    }
}
