package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature()
    {
        double result = 0;
        int amount = 0;
        for(Map.Entry<String,Double> entry : temperatures.getTemperatures().entrySet())
        {
            amount++;
            result+= entry.getValue();
        }
        return result/amount;
    }

    public double calculateMedianTemperature()
    {
        double[] temperatureArray = new double[temperatures.getTemperatures().size()];
        int counter = 0;
        for(Map.Entry<String,Double> entry : temperatures.getTemperatures().entrySet())
        {
            temperatureArray[counter] = entry.getValue();
            counter++;
        }
        Arrays.sort(temperatureArray);
        if(temperatureArray.length % 2 == 0)
            return  ((temperatureArray[temperatureArray.length/2])+((temperatureArray[(temperatureArray.length/2)-1])))/2.0;
            else return temperatureArray[(int)(temperatureArray.length/2)];
    }
}