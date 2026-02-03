package com.kodilla.rps.GameCore.pokemonss;

import com.kodilla.rps.GameCore.Figure;

public class Bulbasaur extends Figure {
    public Bulbasaur()
    {
        this.name = "Bulbasaur";
        this.imagePath = "/pokemon/BulbasaurWithAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "I want to cry...";
        clues[1] = "What stinks so much?";
        clues[2] = "I sense some patriotic aura.";
    }
}
