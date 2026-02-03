package com.kodilla.rps.gameController;

import com.kodilla.rps.GameCore.*;
import com.kodilla.rps.GameCore.pokemonss.Charmander;
import com.kodilla.rps.GameCore.pokemonss.Squirtle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTestSuite {
    @Test
    void testRoundCount() {
        GameController gameController = new GameController(10, GameMode.CLASSIC_GAME, DifficultLevel.NORMAL);
        gameController.setPlayerFigure(new Charmander());
        gameController.startFight();
        gameController.startFight();
        gameController.startFight();
        assertEquals(4, gameController.getCurrentRound());
    }

    @Test
    void testScoreCounting()
    {
        GameController gameController = new GameController(10, GameMode.CLASSIC_GAME, DifficultLevel.NORMAL);
        Figure figure1 = new Charmander();
        Figure figure2 = new Squirtle();
        figure1.setFigureFightResult(figure2, FightResults.YIELDS);
        gameController.setPlayerFigure(figure1);
        gameController.setAIFigure(figure2);
        gameController.startFight();
        gameController.startFight();
        gameController.setPlayerFigure(figure2);
        gameController.setAIFigure(figure1);
        gameController.startFight();

        assertEquals(1, gameController.getPlayerScore());
        assertEquals(2, gameController.getAIScore());
    }
    @Test
    void testScoreCountingWithMaxDifficult()
    {
        GameController gameController = new GameController(10, GameMode.CLASSIC_GAME, DifficultLevel.ABNORMAL);
        Figure figure1 = new Charmander();
        Figure figure2 = new Squirtle();
        figure1.setFigureFightResult(figure2, FightResults.YIELDS);
        gameController.setPlayerFigure(figure1);
        gameController.setAIFigure(figure2);
        gameController.startFight();
        gameController.startFight();
        gameController.setPlayerFigure(figure2);
        gameController.setAIFigure(figure1);
        gameController.startFight();
        gameController.setPlayerFigure(figure1);
        gameController.setAIFigure(figure1);
        gameController.startFight();

        assertEquals(1, gameController.getPlayerScore());
        assertEquals(4, gameController.getAIScore());
    }
}
