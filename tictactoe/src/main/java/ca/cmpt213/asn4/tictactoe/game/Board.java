package ca.cmpt213.asn4.tictactoe.game;

/**
 * Class Board. Represents the board with a two-dimensional array containing ints with values 0, 1, and 2.
 * 0 represents an empty box, 1 an X, and 2 an O. Also contains methods for the logic of the game.
 * These methods include checking for whether a player won, getting a box value, clearing the board, and more.
 * @author Alex Ramirez
 * @version 1.0
 */
public class Board {
    private static int[][] board = new int[4][4]; // 0: Empty, 1: X, 2: O

    public static int[][] getBoard() {
        return board;
    }

    public static void clearBoard() {
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                board[i][j] = 0;
            }
        }
    }

    public static void setBoardElementValue(int value, int i, int j) {
        board[i][j] = value;
    }

    public static int getBoardElementValue(int i, int j) {
        return board[i][j];
    }

    public static void printBoard() {
        for ( int i = 0; i < 4; i++ ) {
            System.out.print("[ ");
            for ( int j = 0; j < 4; j++ ) {
                if ( j == 3 ) {
                    System.out.print(getBoard()[i][j] + " ");
                }
                else {
                    System.out.print(getBoard()[i][j] + ", ");
                }
            }
            System.out.print("]\n");
        }
    }

    public static boolean didXWin() {
        // Check first row
        if ( getBoard()[0][0] == 1 && getBoard()[0][1] == 1 && getBoard()[0][2] == 1 && getBoard()[0][3] == 1 ) {
            return true;
        }
        // Check second row
        else if ( getBoard()[1][0] == 1 && getBoard()[1][1] == 1 && getBoard()[1][2] == 1 && getBoard()[1][3] == 1 ) {
            return true;
        }
        // Check third row
        else if ( getBoard()[2][0] == 1 && getBoard()[2][1] == 1 && getBoard()[2][2] == 1 && getBoard()[2][3] == 1 ) {
            return true;
        }
        // Check fourth row
        else if ( getBoard()[3][0] == 1 && getBoard()[3][1] == 1 && getBoard()[3][2] == 1 && getBoard()[3][3] == 1 ) {
            return true;
        }
        // Check the first column
        else if ( getBoard()[0][0] == 1 && getBoard()[1][0] == 1 && getBoard()[2][0] == 1 && getBoard()[3][0] == 1 ) {
            return true;
        }
        // Check the second column
        else if ( getBoard()[0][1] == 1 && getBoard()[1][1] == 1 && getBoard()[2][1] == 1 && getBoard()[3][1] == 1 ) {
            return true;
        }
        // Check the third column
        else if ( getBoard()[0][2] == 1 && getBoard()[1][2] == 1 && getBoard()[2][2] == 1 && getBoard()[3][2] == 1 ) {
            return true;
        }
        // Check the fourth column
        else if ( getBoard()[0][3] == 1 && getBoard()[1][3] == 1 && getBoard()[2][3] == 1 && getBoard()[3][3] == 1 ) {
            return true;
        }
        // Check the first diagonal
        else if ( getBoard()[0][0] == 1 && getBoard()[1][1] == 1 && getBoard()[2][2] == 1 && getBoard()[3][3] == 1 ) {
            return true;
        }
        // Check the second diagonal
        else if ( getBoard()[0][3] == 1 && getBoard()[1][2] == 1 && getBoard()[2][1] == 1 && getBoard()[3][0] == 1 ) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean didOWin() {
        // Check first row
        if ( getBoard()[0][0] == 2 && getBoard()[0][1] == 2 && getBoard()[0][2] == 2 && getBoard()[0][3] == 2 ) {
            return true;
        }
        // Check second row
        else if ( getBoard()[1][0] == 2 && getBoard()[1][1] == 2 && getBoard()[1][2] == 2 && getBoard()[1][3] == 2 ) {
            return true;
        }
        // Check third row
        else if ( getBoard()[2][0] == 2 && getBoard()[2][1] == 2 && getBoard()[2][2] == 2 && getBoard()[2][3] == 2 ) {
            return true;
        }
        // Check fourth row
        else if ( getBoard()[3][0] == 2 && getBoard()[3][1] == 2 && getBoard()[3][2] == 2 && getBoard()[3][3] == 2 ) {
            return true;
        }
        // Check the first column
        else if ( getBoard()[0][0] == 2 && getBoard()[1][0] == 2 && getBoard()[2][0] == 2 && getBoard()[3][0] == 2 ) {
            return true;
        }
        // Check the second column
        else if ( getBoard()[0][1] == 2 && getBoard()[1][1] == 2 && getBoard()[2][1] == 2 && getBoard()[3][1] == 2 ) {
            return true;
        }
        // Check the third column
        else if ( getBoard()[0][2] == 2 && getBoard()[1][2] == 2 && getBoard()[2][2] == 2 && getBoard()[3][2] == 2 ) {
            return true;
        }
        // Check the fourth column
        else if ( getBoard()[0][3] == 2 && getBoard()[1][3] == 2 && getBoard()[2][3] == 2 && getBoard()[3][3] == 2 ) {
            return true;
        }
        // Check the first diagonal
        else if ( getBoard()[0][0] == 2 && getBoard()[1][1] == 2 && getBoard()[2][2] == 2 && getBoard()[3][3] == 2 ) {
            return true;
        }
        // Check the second diagonal
        else if ( getBoard()[0][3] == 2 && getBoard()[1][2] == 2 && getBoard()[2][1] == 2 && getBoard()[3][0] == 2 ) {
            return true;
        }
        else {
            return false;
        }
    }
}
