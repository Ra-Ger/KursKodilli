package com.kodilla.rps.GameCore;

import com.kodilla.rps.GameCore.generator.FigureSetGenerator;
import com.kodilla.rps.Resources;

public class GameController {
    private int roundCount;
    private Figure[] figures;
    private GameMode gameMode;
    private DifficultLevel difficultLevel;
    private int currentRound;
    private int playerScore;
    private int AIScore;
    private Figure AIFigure;
    private Figure playerFigure;

    public GameController(int roundCount, GameMode gameMode, DifficultLevel difficultLevel) {
        this.roundCount = roundCount;
        this.gameMode = gameMode;
        figures = FigureSetGenerator.getSetFromGameMode(gameMode);
        this.difficultLevel = difficultLevel;
        currentRound = 1;
        playerScore = 0;
        AIScore = difficultLevel == DifficultLevel.ABNORMAL ? (roundCount / 5) : 0;
        AIMakeMove();
    }

    public void AIMakeMove()
    {
        AIFigure = FigureSetGenerator.getRandomFigureFromSet(figures);
    }

    public String tryToGetClue()
    {
        // easy 1/2 normal 1/3 abnormal 1/6
        int generatedNumber = Resources.getRandom().nextInt(6);
        switch (difficultLevel)
        {
            case EASY:
                return generatedNumber < 3 ? AIFigure.getClue() : "";
            case NORMAL:
                return generatedNumber < 2 ? AIFigure.getClue() : "";
            case ABNORMAL:
                return generatedNumber < 1 ? AIFigure.getClue() : "";
            default: return "x";
        }
    }

    public FightResults startFight()
    {
        currentRound++;
        FightResults fr = playerFigure.checkFightResult(AIFigure);
        switch (fr)
        {
            case OVERCOME:
                playerScore++;
                break;
            case YIELDS:
                AIScore++;
                break;
            case TIES:
                break;
        }
        return fr;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Figure[] getFigures() {
        return figures;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public DifficultLevel getDifficultLevel() {
        return difficultLevel;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getAIScore() {
        return AIScore;
    }

    public Figure getAIFigure() {
        return AIFigure;
    }
    // only for testing
    public void  setAIFigure(Figure figure) {
        AIFigure = figure;
    }

    public Figure getPlayerFigure() {
        return playerFigure;
    }

    public void setPlayerFigure(Figure playerFigure) {
        this.playerFigure = playerFigure;
    }
}
