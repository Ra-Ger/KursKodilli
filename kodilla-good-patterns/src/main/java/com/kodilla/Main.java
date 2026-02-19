package com.kodilla;

import com.kodilla.good.patterns.challenges.MovieStore;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String allTitles;
        MovieStore movieStore = new MovieStore();
        allTitles = movieStore.getMovies().values().stream().flatMap(List::stream).map(str -> str + "!").collect(Collectors.joining());
        System.out.println(allTitles);
        int someValue = factorial(3);
        System.out.println(someValue);
    }

    static int factorial(int value) {
        int result = 1;
        for(int i = 1; i <= value; i++)
        {
            result = result * i;
        }
        return result;
    }
}

