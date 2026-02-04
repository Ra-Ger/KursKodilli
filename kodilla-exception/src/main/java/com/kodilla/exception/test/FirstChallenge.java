package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public long pow(long base, long exponent)
    {
        if(base == 0)
        {
            return 0;
        }
        else if(exponent == 0)
        {
            return 1;
        }
        else
        {
            long result = 1;
            for (int i = 0; i < exponent; i++)
            {
                result = result * base;
            }
            return result;
        }

    }
    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try  {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        }
        catch (ArithmeticException ae)
        {
            System.out.println("This is illegal.");
        }
        finally {
            System.out.println("End process.");
        }

    }
}