package com.kodilla.rps.GameCore.pokemonss;

import com.kodilla.rps.GameCore.Figure;

public class Squirtle extends Figure {
    public Squirtle()
    {
        this.name = "Squirtle";
        this.imagePath = "/pokemon/SquirtleWithAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "My opponent seems to want to throw a dead turtle at me.";
        clues[1] = "Could this be... A dead baby?";
        clues[2] = "Did my opponent just piss himself?";
    }
}
