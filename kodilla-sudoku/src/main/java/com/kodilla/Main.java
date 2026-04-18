package com.kodilla;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuGame;
import com.kodilla.sudoku.exceptions.NotEnoughDigits;
import com.kodilla.sudoku.resources.BoardConverter;
import com.kodilla.sudoku.visualInterface.ConsoleInterfaceManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runSolver();
    }

    public static void runSolver() {

        try (Scanner myObj = new Scanner(System.in)) {
            boolean gameFinished = false;

            while (!gameFinished) {
                char[][] startingBoardSetup = new char[SudokuBoard.BOARD_SIZE][SudokuBoard.BOARD_SIZE];

                ConsoleInterfaceManager.printBoard(startingBoardSetup);
                System.out.println("Insert 3 digits where two first are coordinates and third is value. [row][column][value] for example 349");
                System.out.println("Type \"end\" to confirm inserted values.");

                while (true) {
                    String userInput = myObj.nextLine();
                    if (userInput.equalsIgnoreCase("end"))
                        break;
                    try {
                        int[] choice = getFirstThreeDigits(userInput);

                        if (choice[0] < 1 || choice[0] > SudokuBoard.BOARD_SIZE || choice[1] < 1 || choice[1] > SudokuBoard.BOARD_SIZE || choice[2] < 1 || choice[2] > SudokuBoard.BOARD_SIZE) {
                            System.out.println("Coordinates and value must be between 1 and 9.");
                            continue;
                        }

                        startingBoardSetup[choice[0] - 1][choice[1] - 1] = (char) ('0' + choice[2]);
                        ConsoleInterfaceManager.printBoard(startingBoardSetup);
                    } catch (Exception e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    }
                }

                SudokuBoard sudokuToSolve = BoardConverter.fromCharBoardToSudokuBoard(startingBoardSetup);
                char[][] endResult = null;

                try {
                    System.out.println("Solving...");
                    SudokuBoard solvedBoard = SudokuGame.sudokuSolver(sudokuToSolve);
                    endResult = BoardConverter.fromSudokuBoardToCharBoard(solvedBoard);
                } catch (Exception e) {
                    System.out.println("Could not solve the puzzle.");
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("---------------------------------");
                }

                if (endResult != null) {
                    ConsoleInterfaceManager.printBoard(endResult);
                }

                System.out.println("Wanna solve next board? type \"y\" (type anything else to end).");
                gameFinished = !myObj.nextLine().equalsIgnoreCase("y");
            }

        }
        catch (Exception e) {
            System.out.println("Critical error: " + e.getMessage());
        }
    }

    private static int[] getFirstThreeDigits(String text) throws NotEnoughDigits
    {
        if (text == null) throw new NullPointerException("Text is null");

        int[] result = new int[3];
        char[] chars = text.toCharArray();
        int counter = 0;

        for(char c : chars)
        {
            if(Character.isDigit(c))
            {
                result[counter] = Character.getNumericValue(c);
                counter++;
            }

            if(counter > 2)
                break;
        }

        if(counter < 3)
            throw new NotEnoughDigits("Is " + counter + " digits. Must be 3");

        return result;
    }
}