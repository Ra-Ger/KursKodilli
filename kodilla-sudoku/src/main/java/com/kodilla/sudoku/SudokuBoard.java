package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuBoard {
    public static final int BOARD_SIZE = 9;

    private ArrayList<SudokuRow> board = new ArrayList<>();

    public SudokuBoard(ArrayList<SudokuRow> board) {
        this.board = board;
    }

    public ArrayList<SudokuRow> getBoard() {
        return board;
    }

    public SudokuBoard deepCopy()
    {
        ArrayList<SudokuRow> copy = new ArrayList<>();
        for(SudokuRow sr : board)
        {
            copy.add(sr.deepCopy());
        }
        return new SudokuBoard(copy);
    }

    public boolean isSolved()
    {
        for(int i = 0; i < getBoard().size(); i++) {
            for (int j = 0; j < getBoard().get(i).getRow().size(); j++) {
                if (getBoard().get(i).getRow().get(j).getValue() == SudokuElement.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
