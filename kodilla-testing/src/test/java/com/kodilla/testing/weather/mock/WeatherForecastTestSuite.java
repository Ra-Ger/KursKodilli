package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    static Map<String, Double> temperaturesMap = new HashMap<>();
    WeatherForecast weatherForecast;

    @Mock
    private Temperatures temperaturesMock;

    @BeforeAll
    public static void beforeAllTests()
    {
        System.out.println("This is the beginning of tests.");
        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Wroclaw", 24.0);
        temperaturesMap.put("Warszawa", 25.0);
        temperaturesMap.put("Gdansk", 25.0);
    }

    @BeforeEach
    public void beforeEachTest()
    {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Then
        Assertions.assertEquals(5, weatherForecast.calculateForecast().size());
    }

    @Test
    void testCalculateForecastAverageWithMock() {
        //Then
        Assertions.assertEquals(25.0, weatherForecast.calculateAverageTemperature(),0.001);
    }

    @Test
    void testCalculateForecastMedianWithMock() {
        //Then
        Assertions.assertEquals(25.0, weatherForecast.calculateMedianTemperature(),0.001);
    }
}