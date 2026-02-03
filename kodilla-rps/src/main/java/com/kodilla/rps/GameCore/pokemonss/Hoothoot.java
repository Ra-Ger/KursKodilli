package com.kodilla.rps.GameCore.pokemonss;

import com.kodilla.rps.GameCore.Figure;

public class Hoothoot extends Figure {
    public Hoothoot()
    {
        this.name = "Hoothoot";
        this.imagePath = "/pokemon/HoothootWithAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "Red eyes...";
        clues[1] = "I smell... Weed?";
        clues[2] = "the opponent is probably a drug dealer.";
    }
}
