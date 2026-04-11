package com.kodilla.sudoku.visualInterface;


public class ConsoleInterfaceManager {

    public static void printBoard(char[][] board) {
        if (board == null) return;
        int rows = board.length;
        int cols = board[0].length;

        System.out.print("     ");
        for (int j = 0; j < cols; j++) {
            System.out.printf("%-4d  ", j + 1); //<<<
        }

        System.out.println();

        System.out.print("  _");
        for (int j = 0; j < cols; j++) {
            System.out.printf("______"); //<<<
        }
      //  System.out.print("|");
        System.out.println();

        for (int i = 0; i < rows; i++) {

            System.out.print("  |     ");
            for (int j = 0; j < cols - 1; j++) {
                System.out.print("|     ");
            }
            System.out.print("|");
            System.out.println();

            System.out.printf((i+1)+" |"); //<<<

            for (int j = 0; j < cols; j++) {
                System.out.printf("  %c  ", getChar(board, i, j));

                if (j < cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.print("|");
            System.out.println();


                System.out.print("  |_____");
                for (int j = 0; j < cols - 1; j++) {
                    System.out.print("|_____");
                }

            System.out.print("|");
            System.out.println();
        }
    }

    private static char getChar(char[][] board, int row, int col) {
        if (board == null || row >= board.length || col >= board[0].length) {
            return ' ';
        }
        char c = board[row][col];
        return (c == '\u0000' || c == ' ') ? ' ' : c;
    }
}