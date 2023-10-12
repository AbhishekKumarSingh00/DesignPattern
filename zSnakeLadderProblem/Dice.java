package zSnakeLadderProblem;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int min = 1; // minimum value on dice can appear
    int max = 6; // maximum value on dice can appear

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int totalSum = 0;
// throws total of number shown in dice. No. of dices(dice used) is scalable meaning more than 1 dice can be used in future.
        int diceUsed = 0;

        while(diceUsed < diceCount) {

            totalSum += ThreadLocalRandom.current().nextInt(min, max + 1);
            diceUsed++;
        }
        return totalSum;
    }

    // TODO : getters and setters

}
