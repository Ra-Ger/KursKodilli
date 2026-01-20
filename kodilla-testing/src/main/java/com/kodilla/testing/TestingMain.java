package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain
{

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        int calculatorOutput = calculator.add(27,3);
        if (calculatorOutput == 30) {
            System.out.println("dodawanie OK");
        } else {
            System.out.println("Error!");
        }

        calculatorOutput = calculator.subtract(33,3);
        if (calculatorOutput == 30) {
            System.out.println("odejmowanie OK");
        } else {
            System.out.println("Error!");
        }
    }
}


