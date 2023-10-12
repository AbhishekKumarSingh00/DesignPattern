package ticTacToeProblem.model;

import java.util.HashMap;

public class Board {

    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if(board[row][column] != null)
            return false;
        board[row][column] = playingPiece;
        return true;
    }

    public HashMap<Integer, Integer> getFreeCells() {
        HashMap<Integer, Integer> freeCells = new HashMap<>();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    freeCells.put(i, j);
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] != null)
                    System.out.print(board[i][j].pieceType.name() + "    ");
                else
                    System.out.print("    ");
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
