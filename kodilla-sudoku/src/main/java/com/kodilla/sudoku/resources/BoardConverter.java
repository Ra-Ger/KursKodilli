package com.kodilla.sudoku.resources;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuRow;

import java.util.ArrayList;

public class BoardConverter {

    static char emp = '\u0000';

    public static char[][] fromSudokuBoardToCharBoard(SudokuBoard sb)
    {
        char[][] result = new char[SudokuBoard.BOARD_SIZE][SudokuBoard.BOARD_SIZE];
        for(int row = 0; row < sb.getBoard().size(); row++)
        {
            for(int col = 0; col < sb.getBoard().get(row).getRow().size();col++)
            {
                int value = sb.getBoard().get(row).getRow().get(col).getValue();
                result[row][col] = value == -1 ? emp : (char)('0'+value);
            }
        }
        return result;
    }

    public static SudokuBoard fromCharBoardToSudokuBoard(char[][] cb)
    {
        ArrayList<SudokuRow> finalBoard = new ArrayList<>();
        for(int row = 0; row < cb.length;row++)
        {
            ArrayList<SudokuElement> segment = new ArrayList<>();
            for(int col = 0; col < cb[row].length;col++)
            {
                segment.add(cb[row][col] == emp ? new SudokuElement() : new SudokuElement(Character.getNumericValue(cb[row][col])));
            }
            finalBoard.add(new SudokuRow(segment));
        }
        return new SudokuBoard(finalBoard);
    }
}
