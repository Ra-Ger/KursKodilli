package com.kodilla.good.patterns.challenges.flyingSymulator;

import java.util.*;
import java.util.stream.Collectors;

public class FlightService {

    private Map<City, List<Flight>> flightsFromCity = new HashMap<>();

    public void addFlight(Flight flight) {
        flightsFromCity.computeIfAbsent(flight.getFrom(), k -> new ArrayList<>()).add(flight);
    }

    public List<Flight> directConnections(City from, City to) {
        return flightsFromCity.getOrDefault(from,new ArrayList<>()).stream()
                .filter(flight -> flight.getTo().equals(to))
                .collect(Collectors.toList());
    }

    public List<List<Flight>> findConnectingFlights(City from, City to) {
        List<List<Flight>> allResults = new ArrayList<>();
        search(from, to, new ArrayList<>(), allResults);
        return allResults;
    }

    private void search(City currentCity, City destination, List<Flight> currentPath, List<List<Flight>> allResults) {
        if (currentPath.size() > 4) return;

        List<Flight> availableFlights = flightsFromCity.getOrDefault(currentCity, new ArrayList<>());

        for (Flight flight : availableFlights) {
            if (!currentPath.isEmpty()) {
                Flight lastFlight = currentPath.get(currentPath.size() - 1);

                boolean sameDay = flight.getFlightDate().equals(lastFlight.getFlightDate());
                boolean afterPreviousArrival = flight.getDepartureTime().isAfter(lastFlight.getArrivalTime());

                if (!sameDay || !afterPreviousArrival) {
                    continue;
                }
            }

            if (isCityAlreadyVisited(flight.getTo(), currentPath)) {
                continue;
            }

            currentPath.add(flight);

            if (flight.getTo().equals(destination)) {
                if(currentPath.size() > 1)
                   allResults.add(new ArrayList<>(currentPath));
            } else {
                search(flight.getTo(), destination, currentPath, allResults);
            }

            currentPath.remove(currentPath.size() - 1);
        }
    }

    private boolean isCityAlreadyVisited(City city, List<Flight> path) {
        return path.stream().anyMatch(f -> f.getFrom().equals(city));
    }

    public FlightDTO process(City from, City to)
    {
        String information = "Flights from " + from.getName() + " to " + to.getName() + ":";
        List<Flight> directFlights = directConnections(from,to);
        List<List<Flight>> connectingFlights = findConnectingFlights(from,to);
        information += "\nDirect connections:";
        if(directFlights.isEmpty())
            information += "\nNo direct connection available.";
        else
        {
            information += "\n " + displayFlightPath(directFlights);
        }
        information += "\nconnecting Flights:";

        if(connectingFlights.isEmpty())
            information += "\nNo connecting flights available.";
        else
        {
            information += "\n";
            for(List<Flight> listFlights : connectingFlights)
            {
                information += displayFlightPath(listFlights);
            }
        }

        return new FlightDTO(information,directFlights,connectingFlights);
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
