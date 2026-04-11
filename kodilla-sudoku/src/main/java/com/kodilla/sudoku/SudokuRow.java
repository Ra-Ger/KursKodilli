package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private ArrayList<SudokuElement> row = new ArrayList<>();

    public SudokuRow(ArrayList<SudokuElement> row) {
        this.row = row;
    }

    public ArrayList<SudokuElement> getRow() {
        return row;
    }

    public SudokuRow deepCopy()
    {
        ArrayList<SudokuElement> rowCopy = new ArrayList<>();
        for(SudokuElement se : row)
        {
            rowCopy.add(se.deepCopy());
        }
        return new SudokuRow(rowCopy);
    }
}
