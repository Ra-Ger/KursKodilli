package com.kodilla.rps.GameCore.classicGame;

import com.kodilla.rps.GameCore.FightResults;
import com.kodilla.rps.GameCore.Figure;

import java.util.Map;

public class Scissors extends Figure {
    public Scissors() {
        this.name = "Scissors";
        this.imagePath = "/classic/ScissorsAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "You can stir tea with it.";
        clues[1] = "Metallic sound...";
        clues[2] = "The opponent probably has a case of butterfly knife nerves.";
    }
}
