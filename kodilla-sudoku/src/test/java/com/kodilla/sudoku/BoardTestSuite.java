package com.kodilla.sudoku;

import com.kodilla.sudoku.resources.BoardConverter;
import com.kodilla.sudoku.visualInterface.ConsoleInterfaceManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    static char emp = '\u0000';
    char[][] exampleBoard = {
                {emp, '3', '4', emp, '7', '8', emp, '1', '2'},
                {'6', emp, '2', '1', '9', '5', '3', '4', emp},
                {'1', '9', emp, '3', emp, '2', '5', '6', '7'},
                {'8', '5', '9', emp, '6', '1', emp, '2', '3'},
                {emp, '2', emp, '8', emp, '3', '7', '9', emp},
                {'7', '1', '3', '9', '2', emp, '8', '5', '6'},
                {'9', emp, '1', '5', '3', '7', emp, '8', '4'},
                {'2', '8', '7', emp, '1', '9', '6', emp, '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', emp}
        };

    @Test
    void convertToSudokuBoardTest()
    {
        //When
        SudokuBoard sudokuBoard = BoardConverter.fromCharBoardToSudokuBoard(exampleBoard);
        //Then
        assertEquals(SudokuElement.EMPTY,sudokuBoard.getBoard().get(2).getRow().get(2).getValue());
        assertEquals(6,sudokuBoard.getBoard().get(1).getRow().get(0).getValue());
    }

    @Test
    void convertToCharBoardTest()
    {
        //Given
        ConsoleInterfaceManager.printBoard(exampleBoard);
        SudokuBoard sudokuBoard = BoardConverter.fromCharBoardToSudokuBoard(exampleBoard);
        //When
        char[][] board = BoardConverter.fromSudokuBoardToCharBoard(sudokuBoard);
        ConsoleInterfaceManager.printBoard(board);
        //Then
        assertEquals(emp,board[8][8]);
        assertEquals('8',board[5][6]);
    }

    @Test
    void copyBoardTest()
    {
        //Given
        SudokuBoard sudokuBoard = BoardConverter.fromCharBoardToSudokuBoard(exampleBoard);
        //When
        SudokuBoard deepCopy = sudokuBoard.deepCopy();
        sudokuBoard.getBoard().get(0).getRow().get(0).setValue(5);
        //Then
        assertEquals(SudokuElement.EMPTY,deepCopy.getBoard().get(0).getRow().get(0).getValue());
        assertEquals(5,sudokuBoard.getBoard().get(0).getRow().get(0).getValue());
    }
}
