package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class SearchEngineRunner {
    public static void main(String[] args)
    {
        Flight flight;
        Flight flight1 = new Flight("Sosnowiec","Radom");
        Flight flight2 = new Flight("Podlasie","Łódź");
        Flight flight3 = new Flight("Sosnowiec","Podlasie");

        Map<String,Boolean> awailableFlight = new HashMap<>();
        awailableFlight.put("Radom",true);
        awailableFlight.put("Sosnowiec",true);
        awailableFlight.put("Podlasie",false);

        FlightSearchEngine fse = new FlightSearchEngine(awailableFlight);
        flight = flight1;

        try {
            if(fse.findFlight(flight))
              System.out.println("Flight to " + flight.getArrivalAirport() + " from " + flight.getDepartureAirport() +" is awailable");
            else System.out.println("Flight to " + flight.getArrivalAirport() + " from " + flight.getDepartureAirport() +" is not awailable");
        }
        catch (RouteNotFoundException rnfe)
        {
            System.out.println(rnfe);
        }
    }
}
