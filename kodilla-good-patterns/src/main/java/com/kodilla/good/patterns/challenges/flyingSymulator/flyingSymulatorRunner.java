package com.kodilla.good.patterns.challenges.flyingSymulator;


import java.time.LocalDate;
import java.time.LocalTime;

public class flyingSymulatorRunner {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();

        City warsaw = new City("Warsaw");
        City dubai = new City("Dubai");
        City tibilisi = new City("Tibilisi");
        City pjongjang = new City("Piongjang");

        Flight flight1 = new Flight(warsaw,dubai, LocalDate.of(2025, 3, 15),
                LocalTime.of(14, 30),LocalTime.of(14, 35));
        Flight flight2 = new Flight(dubai,tibilisi, LocalDate.of(2025, 3, 15),
                LocalTime.of(14, 40),LocalTime.of(14, 45));
        Flight flight3 = new Flight(tibilisi,pjongjang, LocalDate.of(2025, 3, 15),
                LocalTime.of(14, 50),LocalTime.of(15, 35));

        flightService.addFlight(flight1);
        flightService.addFlight(flight2);
        flightService.addFlight(flight3);

        System.out.println(flightService.process(warsaw,dubai).getInformation() + "\n");
        System.out.println(flightService.process(warsaw,pjongjang).getInformation());
    }
}
