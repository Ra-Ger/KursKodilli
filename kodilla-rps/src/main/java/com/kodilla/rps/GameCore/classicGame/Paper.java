package com.kodilla.rps.GameCore.classicGame;

import com.kodilla.rps.GameCore.Figure;

public class Paper extends Figure {
    public Paper() {
        this.name = "Paper";
        this.imagePath = "/classic/PaperWithAlphaChanel.png";
        this.clues = new String[3];
        clues[0] = "It can give you a cruel cut!";
        clues[1] = "You can add it to a salad!";
        clues[2] = "An engineer could even make an airplane out of it!";
    }
}
