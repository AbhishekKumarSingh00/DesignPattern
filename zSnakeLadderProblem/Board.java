package zSnakeLadderProblem;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {

        cells = new Cell[boardSize][boardSize];

        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();;
            }
        }

    }

    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {

        while(numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(snakeHead > snakeTail) {
                Jump snakeJump = new Jump();
                snakeJump.start = snakeHead;
                snakeJump.end = snakeTail;

                Cell cell = getCell(snakeHead);
                cell.jump = snakeJump;
                numberOfSnakes--;
            }
        }

        while(numberOfLadders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(ladderHead < ladderTail) {
                Jump snakeJump = new Jump();
                snakeJump.start = ladderHead;
                snakeJump.end = ladderTail;

                Cell cell = getCell(ladderHead);
                cell.jump = snakeJump;
                numberOfLadders--;
            }
        }

    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardCol = (playerPosition % cells.length);

        return cells[boardRow][boardCol];
    }


}
