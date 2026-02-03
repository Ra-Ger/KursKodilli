package com.kodilla.rps.GameCore.visualInterface;

import com.kodilla.rps.GameCore.DifficultLevel;
import com.kodilla.rps.GameCore.FightResults;
import com.kodilla.rps.GameCore.GameController;
import com.kodilla.rps.GameCore.GameMode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.*;

public class FrameManager extends JFrame {

    GameController gameController;
    private JPanel activeGameBoard;
    private HashSet<IOnSceneChange> observersList = new HashSet<>();


    public FrameManager() {

        setTitle("Papier, kamień, pokemon.");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        showNewGame();

        setVisible(true);
    }

    public void showNewGame() {
        NewGame settings = new NewGame(this);
        setContentPane(settings.getMainPanel());
        PRR();
    }

    public void startGame(int rounds, GameMode gameMode, DifficultLevel difficultLevel) {

        observersList.clear();
        gameController = new GameController(rounds, gameMode, difficultLevel);
        Display game = new Display(this);
        this.activeGameBoard = game.getMainPanel();
        setContentPane(activeGameBoard);
        PRR();
    }

    public void backToDisplay()
    {
        if (activeGameBoard != null) {
            sceneWasChanged();
            setContentPane(activeGameBoard);
            PRR();
        }
    }

    public void showFightResult()
    {
        FightResult fightResult = new FightResult(this);
        setContentPane(fightResult.MainPanel);
        PRR();
    }

    public void showGameOver()
    {
        GameOver gameOver = new GameOver(this);
        setContentPane(gameOver.MainPanel);
        PRR();
    }

    private void PRR()
    {
        pack();
        revalidate();
        repaint();
    }

    public void addToObserverList(IOnSceneChange observer)
    {
        observersList.add(observer);
    }

    public void removeFromObserverList(IOnSceneChange observer)
    {
        observersList.remove(observer);
    }

    private void sceneWasChanged()
    {
        for(IOnSceneChange osc : observersList)
        {
            osc.onSceneChange();
        }
    }

    public GameController getGameController()
    {
        return gameController;
    }
}
