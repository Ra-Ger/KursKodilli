package com.kodilla.rps;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Resources {
    public static Random getRandom()
    {
        return new Random();
    }
    public static String getRandomWinBattleLog(String winner,String loser)
    {
        List<String> battleLogList = new ArrayList<>();
        battleLogList.add(winner + " bite " + loser + " ass. Attack was super effective!");
        battleLogList.add(winner + " told a dirty joke about " + loser + " mom. " + loser + " burst into tears. " +" Attack was super effective!");
        battleLogList.add(winner + " throw a rock at " + loser + " hitting it straight in head. Attack was super effective!");
        battleLogList.add(winner + " use tactical nuke against " + loser + ". Attack was moderately effective!");
        battleLogList.add(loser  + " jump on " + winner + " and starts beating him relentlessly. After a moment, it turned out to be just a dummy. Meanwhile " + winner + " put a Beretta 92 to " + loser + " head and pulled the trigger.");

        return battleLogList.get(getRandom().nextInt(battleLogList.size()));
    }

    public static String getRandomLoseBattleLog(String winner,String loser)
    {
        List<String> battleLogList = new ArrayList<>();
        battleLogList.add(winner + " just watches as "+ loser + " forgot how to breathe and immediately suffocated");
        battleLogList.add(loser + " tries to kick " + winner + " but accidentally hits itself in the face and knocks out all his teeth.");
        battleLogList.add(loser + " charge at " + winner + " but it slipped on a tangerine peel and fell into the garbage can.");

        return battleLogList.get(getRandom().nextInt(battleLogList.size()));
    }

    public static String getRandomTieBattleLog(String firstFigure,String secoundFigure)
    {
        List<String> battleLogList = new ArrayList<>();
        battleLogList.add(firstFigure + " looks motionless at " + secoundFigure + " which also stands still and after a two hours nothing happened.");
        battleLogList.add("both creatures hit each other with their paws but it doesn't seem like either of them has the advantage...");
        battleLogList.add(firstFigure +  " strangles " + secoundFigure + " but " + secoundFigure + " thinks that " + firstFigure + " is hugging it so he proposes and now they are going to get married.");

        return battleLogList.get(getRandom().nextInt(battleLogList.size()));
    }

    public static void setImage(JLabel label, String imagePath, int width, int height, Object o) {
        java.net.URL imgURL = o.getClass().getResource(imagePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } else {
            System.out.println("No file found: " + imagePath);
        }
    }
}
