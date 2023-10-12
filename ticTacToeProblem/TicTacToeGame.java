package ticTacToeProblem;

import ticTacToeProblem.model.*;

import java.util.*;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame() {
        initalizeGame();
    }

    public void initalizeGame() {

        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("player1", crossPiece);

        PlayingPieceO zeroPiece = new PlayingPieceO();
        Player player2 = new Player("player2", zeroPiece);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {

            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            HashMap<Integer, Integer> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("player : " + playerTurn.name + "Enter row, column : ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputCol, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputCol, playerTurn.playingPiece.pieceType);
            if(winner) {
                return playerTurn.name;
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType)
                    rowMatch = false;
        }

        for(int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType)
                colMatch = false;
        }
        for(int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[i][i] == null || gameBoard.board[i][i].pieceType != pieceType)
                diagonalMatch = false;
        }
        for(int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[i][gameBoard.size - i - 1] == null || gameBoard.board[i][gameBoard.size - i - 1].pieceType != pieceType)
                antiDiagonalMatch = false;
        }
//        for(int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
//            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType)
//                antiDiagonalMatch = false;
//        }

        return rowMatch || colMatch || antiDiagonalMatch || diagonalMatch;
    }

}
