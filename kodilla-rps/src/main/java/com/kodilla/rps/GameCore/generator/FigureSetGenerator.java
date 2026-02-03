package com.kodilla.rps.GameCore.generator;

import com.kodilla.rps.GameCore.FightResults;
import com.kodilla.rps.GameCore.Figure;
import com.kodilla.rps.GameCore.GameMode;
import com.kodilla.rps.GameCore.pokemonss.*;
/*import com.kodilla.rps.GameCore.pokemons.*;
import com.kodilla.rps.GameCore.pokemons.Bulbasaur;
import com.kodilla.rps.GameCore.pokemons.Charmander;
import com.kodilla.rps.GameCore.pokemons.Squirtle;*/
import com.kodilla.rps.GameCore.classicGame.Paper;
import com.kodilla.rps.GameCore.classicGame.Rock;
import com.kodilla.rps.GameCore.classicGame.Scissors;
import com.kodilla.rps.Resources;

public class FigureSetGenerator {
    public static Figure[] getSetFromGameMode(GameMode gameMode)
    {
        switch (gameMode)
        {
            case CLASSIC_GAME:
                return getClassicSet();
            case POKEMON_GAME:
                return getPokemonSet();
            case POKEMON_PLUS:
                return getPokemonPlusSet();
            case MULTIVERSE_WAR:
                return getMultiverseSet();
            default: return getClassicSet();
        }
    }

    public static Figure[] getClassicSet()
    {
        Figure[] figures = new Figure[3];
        figures[0] = new Paper();
        figures[1] = new Rock();
        figures[2] = new Scissors();
        figures[0].setFigureFightResult(figures[1], FightResults.OVERCOME);
        figures[1].setFigureFightResult(figures[2], FightResults.OVERCOME);
        figures[2].setFigureFightResult(figures[0], FightResults.OVERCOME);
        return figures;
    }

    public static Figure[] getPokemonSet()
    {
        Figure[] figures = new Figure[3];
        figures[0] = new Squirtle();
        figures[1] = new Charmander();
        figures[2] = new Bulbasaur();
        figures[0].setFigureFightResult(figures[1], FightResults.OVERCOME);
        figures[1].setFigureFightResult(figures[2], FightResults.OVERCOME);
        figures[2].setFigureFightResult(figures[0], FightResults.OVERCOME);
        return figures;
    }

    public static Figure[] getPokemonPlusSet() {
        Figure[] figures = new Figure[5];
        figures[0] = new Squirtle();
        figures[1] = new Charmander();
        figures[2] = new Bulbasaur();
        figures[3] = new Pikachu();
        figures[4] = new Hoothoot();

        figures[0].setFigureFightResult(figures[1], FightResults.OVERCOME);
        figures[1].setFigureFightResult(figures[2], FightResults.OVERCOME);
        figures[2].setFigureFightResult(figures[0], FightResults.OVERCOME);
        figures[2].setFigureFightResult(figures[3], FightResults.OVERCOME); // bulbasaur bije pikachu
        figures[3].setFigureFightResult(figures[0], FightResults.OVERCOME); // pikachu bije squirta
        figures[3].setFigureFightResult(figures[4], FightResults.OVERCOME); // pikachu bije hothota
        figures[4].setFigureFightResult(figures[2], FightResults.OVERCOME); // hothot bije bulbasaura
        return figures;
    }

    public static Figure[] getMultiverseSet()
    {
        Figure[] figures = new Figure[getPokemonPlusSet().length + getClassicSet().length];
        System.arraycopy(getPokemonPlusSet(), 0, figures, 0, getPokemonPlusSet().length);
        System.arraycopy(getClassicSet(), 0, figures, getPokemonPlusSet().length, getClassicSet().length);
        figures[5].setFigureFightResult(figures[3], FightResults.OVERCOME); // papier dusi pikacza
        figures[6].setFigureFightResult(figures[1], FightResults.OVERCOME);
        figures[6].setFigureFightResult(figures[2], FightResults.OVERCOME);
        figures[6].setFigureFightResult(figures[3], FightResults.OVERCOME);
        figures[6].setFigureFightResult(figures[4], FightResults.OVERCOME); // kamień zabija wszystkie nie licząc sqirtla bo on ma armatke wodnom
        figures[7].setFigureFightResult(figures[2], FightResults.OVERCOME); // norzyce tnom bulb
        figures[0].setFigureFightResult(figures[6], FightResults.OVERCOME); // squirt odbija kamien
        figures[2].setFigureFightResult(figures[5], FightResults.OVERCOME); // cahrmander pali papier
        figures[2].setFigureFightResult(figures[7], FightResults.OVERCOME); // cahrmander pali nozyce
        figures[4].setFigureFightResult(figures[5], FightResults.OVERCOME); // hothot robi blanta z papieru
        figures[0].setFigureFightResult(figures[5], FightResults.OVERCOME); // sqirtl rozpuszcza papier

        //5 papier 6 kamien 7 norzyce

        return figures;
    }

    public static Figure getRandomFigureFromSet(Figure[] figureSet)
    {
        return figureSet[Resources.getRandom().nextInt(figureSet.length)];
    }
}
