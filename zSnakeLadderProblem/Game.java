package zSnakeLadderProblem;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>(); // Took Deque because turn decide karna easy hoga. latest turn will at front.
    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame() {

        while(winner == null) {

            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.printf("player turn is : %s current position is : %d%n", playerTurn.id, playerTurn.currentPosition);

            //roll dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.printf("player turn is : %s new position : %d%n", playerTurn.id, playerTurn.currentPosition);

            //check for winning
            if(playerNewPosition >= board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }

        }

        System.out.println("We got the winner : " + winner.id);

    }

    private Player findPlayerTurn() {
        Player playerTurns = playerList.removeFirst();
        playerList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            System.out.println("Jump done through : " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

}
