package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value = EMPTY;
    private List<Integer> posibilities = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public SudokuElement(int value) {
        this.value = value;
    }

    public SudokuElement() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPosibilities()
    {
        return posibilities;
    }

    public SudokuElement deepCopy()
    {
        SudokuElement copy = new SudokuElement();
        copy.value = this.value;
        copy.posibilities = new ArrayList<>(this.posibilities);
        return copy;
    }
}
