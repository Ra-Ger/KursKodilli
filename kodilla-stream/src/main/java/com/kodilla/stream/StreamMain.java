package com.kodilla.stream;                                                 // [1]

import com.kodilla.stream.lambda.ExecuteSaySomething;                       // [2]
import com.kodilla.stream.lambda.Processor;                                 // [3]

public class StreamMain {                                                   // [4]

    public static void main(String[] args) {                                 // [5]
        Processor processor = new Processor();                                // [6]
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();  // [7]
        processor.execute(executeSaySomething);                               // [8]
    }                                                                        // [9]
}                                                                           // [10]