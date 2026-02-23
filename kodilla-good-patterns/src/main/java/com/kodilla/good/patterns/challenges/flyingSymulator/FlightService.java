package com.kodilla.good.patterns.challenges.flyingSymulator;

import java.util.*;
import java.util.stream.Collectors;

public class FlightService {

    private Map<City, List<Flight>> flightsFromCity = new HashMap<>();
    private Map<City, List<Flight>> flightsToCity = new HashMap<>();

    public void addFlight(Flight flight) {
        flightsFromCity.computeIfAbsent(flight.getFrom(), k -> new ArrayList<>()).add(flight);
        flightsToCity.computeIfAbsent(flight.getTo(), k -> new ArrayList<>()).add(flight);
    }

    List<Flight> findFlightsFrom(City from)
    {
        return flightsFromCity.get(from);
    }
    List<Flight> findFlightsTo(City to)
    {
        return flightsToCity.get(to);
    }

    public List<List<Flight>> findFlightsVia(City from, City via, City to) {
        List<Flight> firstLegs = findFlightsFrom(from).stream()
                .filter(f -> f.getTo().equals(via))
                .collect(Collectors.toList());

        List<Flight> secondLegs = findFlightsFrom(via).stream()
                .filter(f -> f.getTo().equals(to))
                .collect(Collectors.toList());

        List<List<Flight>> results = new ArrayList<>();

        for (Flight first : firstLegs) {
            for (Flight second : secondLegs) {
                if (second.getFlightDate().equals(first.getFlightDate()) &&
                        second.getDepartureTime().isAfter(first.getArrivalTime())) {
                    results.add(List.of(first, second));
                }
            }
        }
        return results;
    }

    public FlightDTO process(City from, City via, City to)
    {

        List<Flight> flightsFrom = findFlightsFrom(from);
        List<Flight> flightsTo = findFlightsTo(to);
        List<List<Flight>> flightsVia = findFlightsVia(from,via,to);

        String information = "Flights from: " + from.getName();
        if(flightsFrom.isEmpty())
            information += "\nNo flights available.";
        else
        {
            information += "\n" + displayFlightPath(flightsFrom);
        }
        information += "\nFlights to: " + to.getName();

        if(flightsTo.isEmpty())
            information += "\nNo flights available.";
        else
        {
            information += "\n" + displayFlightPath(flightsTo);
        }

        information += "\n" + "Flights from: " + from.getName() + " via: " + via.getName() + " to " + to.getName();
        if(flightsVia.isEmpty())
            information += "\nNo flights available.";
        else
        {
            information += "\n";
            for(List<Flight> listFlights : flightsVia)
            {
                information += displayFlightPath(listFlights);
            }
        }

        return new FlightDTO(information,flightsFrom,flightsVia,flightsTo);
    }

    String displayFlightPath(List<Flight> flights)
    {
        String result = "";
        for(Flight flight : flights)
        {
            result += flight.getFrom().getName() + " " + flight.getFlightDate() + " " + flight.getDepartureTime()
                    + " ---> " + flight.getTo().getName() + " " +flight.getArrivalTime() + "\n";
        }
        return result;
    }
}
