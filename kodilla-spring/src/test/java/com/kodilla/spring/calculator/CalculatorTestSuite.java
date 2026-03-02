package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

        double addition2 = calculator.add(-10,-100);
        double subtraction2 = calculator.sub(0.02,5);
        double multiplication2 = calculator.mul(1000,-2.1);

        Exception exception = null;
        try {
            double division2 = calculator.div(1, 0);
        } catch ( Exception e) {
            exception = e;
        }

        assertEquals(5,addition,0.002);
        assertEquals(5,subtraction,0.002);
        assertEquals(5,multiplication,0.002);
        assertEquals(5,division,0.002);

        assertEquals(-110,addition2,0.002);
        assertEquals(-4.98,subtraction2,0.002);
        assertEquals(-2100,multiplication2,0.002);
        assertSame(exception.getClass(), ArithmeticException.class);
    }
}
