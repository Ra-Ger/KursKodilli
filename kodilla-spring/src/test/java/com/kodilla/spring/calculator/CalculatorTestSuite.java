package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations()
    {
        double addition = calculator.add(-10,15);
        double subtraction = calculator.sub(10,5);
        double multiplication = calculator.mul(2.5,2);
        double division = calculator.div(25,5);

        assertEquals(5,addition,0.002);
        assertEquals(5,subtraction,0.002);
        assertEquals(5,multiplication,0.002);
        assertEquals(5,division,0.002);
    }
}
