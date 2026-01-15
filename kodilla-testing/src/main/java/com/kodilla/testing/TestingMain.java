package com.kodilla.testing;

public class TestingMain
{
    public static void main(String[] args)
    {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");
    }

    public static String vovelsFilter(String s)
    {
        return s.replaceAll("(?i)[^aąeęiouóy]","");
    }
}


