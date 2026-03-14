package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.HashSet;

public class SudokuElement {
    public static int EMPTY = -1;
    int value = EMPTY;
    HashSet<Integer> posibilities = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
}
