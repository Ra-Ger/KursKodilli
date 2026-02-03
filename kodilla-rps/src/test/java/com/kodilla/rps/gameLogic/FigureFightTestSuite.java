package com.kodilla.rps.gameLogic;

import com.kodilla.rps.GameCore.FightResults;
import com.kodilla.rps.GameCore.Figure;
import com.kodilla.rps.GameCore.classicGame.Paper;
import com.kodilla.rps.GameCore.classicGame.Scissors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureFightTestSuite {
    @Test
    void testFightResult() {
        Figure figure1 = new Scissors();
        Figure figure2 = new Paper();
        figure1.setFigureFightResult(figure2, FightResults.OVERCOME);

        assertEquals(FightResults.OVERCOME, figure1.checkFightResult(figure2));
        assertEquals(FightResults.YIELDS, figure2.checkFightResult(figure1));
        assertEquals(FightResults.TIES, figure1.checkFightResult(figure1));
    }
}
