package com.kodilla.rps.GameCore.classicGame;

import com.kodilla.rps.GameCore.Figure;

public class Rock extends Figure {
    public Rock() {
        this.name = "Rock";
        this.imagePath = "/classic/RockWithAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "You can throw it like a boomerang! Unfortunately, it doesn't come back...";
        clues[1] = "Bad for your teeth!";
        clues[2] = "A delicacy in Latvia.";
    }
}
