package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigMacBuilder()
    {
        Bigmac magicBigamc = new Bigmac.BigmacBuilder()
                .setBun(Bun.ORDINARY)
                .setBurgers(3)
                .setSauce(Sauce.BARBECUE)
                .addIngredient(Ingredient.LETTUCE)
                .addIngredient(Ingredient.BACON)
                .addIngredient(Ingredient.CHEESE)
                .buildBigMac();

        assertEquals(Bun.ORDINARY,magicBigamc.getBun());
        assertEquals(Sauce.BARBECUE,magicBigamc.getSauce());
        assertEquals(3,magicBigamc.getIngredients().size());
    }

    @Test
    void testBigMacBuilderException()
    {
        String exceptionMessage = "";
        try {
            Bigmac magicBigamc = new Bigmac.BigmacBuilder()
                    .setBun(Bun.ORDINARY)
                    .setBurgers(3)
                    .addIngredient(Ingredient.LETTUCE)
                    .addIngredient(Ingredient.BACON)
                    .addIngredient(Ingredient.CHEESE)
                    .buildBigMac();
        }
        catch (Exception e)
        {
            exceptionMessage = e.getMessage();
        }

        assertEquals("Pick sauce or die!",exceptionMessage);
    }
}
