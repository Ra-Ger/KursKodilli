package com.kodilla.stream;                                                   // [1]

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Executor;                                    // [2]
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;                                   // [3]
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {                                                     // [4]

    public static void main(String[] args) {                                   // [5]
        Processor processor = new Processor();                                  // [6]
     //   Executor codeToExecute = () -> System.out.println("This is an example text.");  // [7]
     //   processor.execute(codeToExecute);                                       // [8]
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a % b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a % b + (10*b));
        expressionExecutor.executeExpression(10, 5, (a, b) -> {System.out.println("Zagnieżdżona lambda :D");expressionExecutor.executeExpression(10, 5, (c, e) -> a + b); return a - b;});

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String basicText = "Wyklęty powstań ludu ziemi";
        System.out.println(basicText);
        System.out.println(poemBeautifier.beautify(basicText,(str) -> str.toUpperCase()));
        System.out.println(poemBeautifier.beautify(basicText,(str) -> ":---" + str + "---:"));
        System.out.println(poemBeautifier.beautify(basicText,(str) -> str.replaceFirst("Wyklęty powstań ludu ziemi","Bolszewickie brednie!!!")));
        System.out.println(poemBeautifier.beautify(basicText,(str) -> str.replaceAll("[ ]","_")));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}