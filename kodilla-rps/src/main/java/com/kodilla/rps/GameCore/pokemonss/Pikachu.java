package com.kodilla.rps.GameCore.pokemonss;

import com.kodilla.rps.GameCore.Figure;

public class Pikachu extends Figure {
    public Pikachu()
    {
        this.name = "Pikachu";
        this.imagePath = "/pokemon/PikachuMaUdarWithAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "Enemy probably have Zeus x27";
        clues[1] = "I sense brain damage...";
        clues[2] = "I feel like I'm going to see a surprise.";
    }
}
