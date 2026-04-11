package com.kodilla.sudoku;

import java.util.Objects;

public class BackTrack {

    private SudokuBoard sudokuBoard;
    int row;
    int column;
    private int number;

    public BackTrack(SudokuBoard sudokuBoard, int row, int column, int number) {
        this.sudokuBoard = sudokuBoard;
        this.row = row;
        this.column = column;
        this.number = number;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

}
