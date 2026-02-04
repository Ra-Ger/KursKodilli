package com.kodilla.rps.GameCore;

import com.kodilla.rps.Resources;
import com.sun.source.doctree.EscapeTree;
import java.util.*;

public abstract class Figure {

    protected String name;
    protected String imagePath;
    protected String[] clues;
    protected Map<Figure,FightResults> fightResults = new HashMap<>();

    // dla tego poka ustawiasz innego poka i muwisz czy go rozwala czy przegrywa
    // w skrócie: (ten tutaj) Z tym z parametru, wygra/przegra
    public void setFigureFightResult(Figure figureToFight,FightResults fightResult) {
        if (this.fightResults.containsKey(figureToFight)) {
            return;
        }

        this.fightResults.put(figureToFight,fightResult);
        figureToFight.setFigureFightResult(this,getInverseFightResult(fightResult));
    }

    FightResults getInverseFightResult(FightResults dependice)
    {
        switch (dependice) {
            case FightResults.OVERCOME:
                return FightResults.YIELDS;
            case FightResults.YIELDS:
                return FightResults.OVERCOME;
            default: return FightResults.TIES;
        }
    }

    public FightResults checkFightResult(Figure opponent)
    {
        return fightResults.getOrDefault(opponent, FightResults.TIES);
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String[] getClues() {
        return clues;
    }

    public String getClue()
    {
        return clues == null ? "" : clues[Resources.getRandom().nextInt(clues.length)];
    }

    public Map<Figure, FightResults> getFightResults() {
        return fightResults;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(name, figure.name) && Objects.equals(imagePath, figure.imagePath) && Objects.deepEquals(clues, figure.clues) && Objects.equals(fightResults, figure.fightResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imagePath, Arrays.hashCode(clues), fightResults);
    }
}
