package com.kodilla.good.patterns.challenges.flyingSymulator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Flight {
    private City from;
    private City to;
    private LocalDate flightDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    public Flight(City from, City to, LocalDate flightDate, LocalTime departureTime, LocalTime arrivalTime) {
        this.from = from;
        this.to = to;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() { return arrivalTime;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(from, flight.from) && Objects.equals(to, flight.to) && Objects.equals(flightDate, flight.flightDate) && Objects.equals(departureTime, flight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, flightDate, departureTime);
    }
}
