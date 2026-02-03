package com.kodilla.rps.GameCore.pokemonss;

import com.kodilla.rps.GameCore.Figure;

public class Charmander extends Figure {
    public Charmander()
    {
        this.name = "Charmander";
        this.imagePath = "/pokemon/CharmanderWithAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "Something in the dark smiling at me...";
        clues[1] = "Is this a lizard with Down syndrome?";
        clues[2] = "WTF is this creature?!";
    }
}
