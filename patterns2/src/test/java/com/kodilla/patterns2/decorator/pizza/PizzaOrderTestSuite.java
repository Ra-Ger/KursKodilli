package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class PizzaOrderTestSuite {

    @Test
    void testPizzaBase(){
       Pizza pizza = new PizzaBase();

       System.out.println(pizza.getDescription());
       System.out.println(pizza.getPrice());

       assertEquals("Pizza with: ", pizza.getDescription());
       assertEquals(15, pizza.getPrice(), 0.01);
    }

    @Test
     void testPizzaOrder(){
        Pizza pizza = new PizzaBase();
        pizza = PizzaDecoratorManager.applyExtraHotChilli(pizza);
        pizza = PizzaDecoratorManager.applyExtraHotChilli(pizza);

        pizza = PizzaDecoratorManager.applyCheese(pizza);
        pizza = PizzaDecoratorManager.applyCheese(pizza);
        pizza = PizzaDecoratorManager.applyCheese(pizza);
        pizza = PizzaDecoratorManager.applyCheese(pizza);

        pizza = PizzaDecoratorManager.applySalami(pizza);
        pizza = PizzaDecoratorManager.applySalami(pizza);

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());

        assertEquals("Pizza with:  extra hot chilli cheese x3 salami x2", pizza.getDescription());
        assertEquals(33.5, pizza.getPrice(), 0.01);
    }

    @Test
    void testPizzaOrder2(){
       Pizza pizza = new PizzaBase();

       pizza = PizzaDecoratorManager.applyCheese(pizza);

       pizza = PizzaDecoratorManager.applySalami(pizza);

       System.out.println(pizza.getDescription());
       System.out.println(pizza.getPrice());

       assertEquals("Pizza with:  cheese x1 salami x1", pizza.getDescription());
       assertEquals(20.5, pizza.getPrice(), 0.01);
    }
}
