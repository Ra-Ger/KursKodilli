package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.InvalidBoard;
import java.util.ArrayList;
import java.util.List;

public class SudokuGame {

    public List<BackTrack> backtrackList = new ArrayList<>();

    public boolean checkStartingBoard(SudokuBoard board) {
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().get(i).getRow().size(); j++) {
                int value = board.getBoard().get(i).getRow().get(j).getValue();

                if (value != SudokuElement.EMPTY) {
                    board.getBoard().get(i).getRow().get(j).setValue(SudokuElement.EMPTY);
                    boolean isValid = isAppropriatePlacement(board, i, j, value);
                    board.getBoard().get(i).getRow().get(j).setValue(value);

                    if (!isValid) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public SudokuBoard sudokuSolver(SudokuBoard sudokuBoard) throws InvalidBoard {

        if (!checkStartingBoard(sudokuBoard)) {
            throw new InvalidBoard("This initial board is impossible to solve. Put numbers which doesn't repeats in row column and section!");
        }

        SudokuBoard currentBoard = sudokuBoard;

        while (!currentBoard.isSolved()) {
            if (!solveNextDigit(currentBoard)) {
                if (backtrackList.isEmpty()) {
                    throw new InvalidBoard("Sudoku is impossible to solve.");
                } else {
                    int lastIndex = backtrackList.size() - 1;
                    BackTrack lastTrack = backtrackList.get(lastIndex);

                    currentBoard = lastTrack.getSudokuBoard();
                    int row = lastTrack.getRow();
                    int col = lastTrack.getColumn();
                    Integer failedValue = lastTrack.getNumber();

                    currentBoard.getBoard().get(row).getRow().get(col).getPosibilities().remove(failedValue);

                    backtrackList.remove(lastIndex);
                }
            }
        }
        return currentBoard;
    }

    boolean isNumberInRow(SudokuBoard sudokuBoard, int row, int number)
    {
            for(SudokuElement sudokuElement : sudokuBoard.getBoard().get(row).getRow())
            {
                if(sudokuElement.getValue() != SudokuElement.EMPTY)
                {
                    if(sudokuElement.getValue() == number)
                        return true;
                }
            }
        return false;
    }

    boolean isNumberInColumn(SudokuBoard sudokuBoard, int column, int number)
    {
        for(SudokuRow sudokuRow : sudokuBoard.getBoard())
        {
            if(sudokuRow.getRow().get(column).getValue() != SudokuElement.EMPTY) {
                if (sudokuRow.getRow().get(column).getValue() == number)
                    return true;
            }
        }
        return false;
    }

    boolean isNumberInSection(SudokuBoard sudokuBoard, int row, int column, int number)
    {
        int localRowSection = row - (row % 3);
        int localColumnSection = column - (column % 3);
        for(int i = localRowSection; i < localRowSection + 3; i++)
        {
            for(int j = localColumnSection; j < localColumnSection + 3; j++)
            {
                if(sudokuBoard.getBoard().get(i).getRow().get(j).getValue() != SudokuElement.EMPTY) {
                    if (sudokuBoard.getBoard().get(i).getRow().get(j).getValue() == number)
                        return true;
                }
            }
        }
        return false;
    }

    boolean isAppropriatePlacement(SudokuBoard sudokuBoard, int row, int column, int number)
    {
        return !isNumberInRow(sudokuBoard,row,number) && !isNumberInColumn(sudokuBoard,column,number) && !isNumberInSection(sudokuBoard,row,column,number);
    }

    boolean solveNextDigit(SudokuBoard sudokuBoard) {
        for (int i = 0; i < sudokuBoard.getBoard().size(); i++) {
            for (int j = 0; j < sudokuBoard.getBoard().get(i).getRow().size(); j++) {

                SudokuElement currentElement = sudokuBoard.getBoard().get(i).getRow().get(j);

                if (currentElement.getValue() == SudokuElement.EMPTY) {

                    for (int it = 0; it < currentElement.getPosibilities().size(); it++) {
                        int valueToTry = currentElement.getPosibilities().get(it);

                        if (isAppropriatePlacement(sudokuBoard, i, j, valueToTry)) {
                            backtrackList.add(new BackTrack(sudokuBoard.deepCopy(), i, j, valueToTry));
                            currentElement.setValue(valueToTry);
                            return true;
                        } else {
                            currentElement.getPosibilities().remove(it);
                            it--;
                        }
                    }

                    if (currentElement.getPosibilities().isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
