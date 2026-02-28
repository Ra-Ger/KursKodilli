package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private Bun bun;
    private int burgers;
    private Sauce sauce;
    private List<Ingredient> ingredients = new ArrayList<>();

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers = 1;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder setBun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder setBurgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder setSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder addIngredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac buildBigMac()
        {
            if(bun == null)
                throw new IllegalStateException("BigMac isn't yourself without bun!");
            else if(burgers < 1 || burgers > 6)
                throw new IllegalStateException("Set burgers count properly!");
            else if(sauce == null)
                throw new IllegalStateException("Pick sauce or die!");
            else if(ingredients.size() < 3)
                throw new IllegalStateException("Add more ingredients!");

            return new Bigmac(bun,burgers,sauce,ingredients);
        }
    }

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }
}
