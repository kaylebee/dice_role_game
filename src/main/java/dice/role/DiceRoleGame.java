package dice.role;

import java.util.Random;

/**
 * The Game class simulates a dice roll game.
 */
public class DiceRoleGame {
    // The number of times the game is played
    private static final int ROLLS = 10000;
    // Random number generator for the dice rolls
    private static final Random RANDOM = new Random();
    /**
     * Main method running the game simulation.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Integer[] sequence1 = {1, 2, 3};
        Integer[] sequence2 = {4, 5, 6};

        int player1Wins = 0;
        int player2Wins = 0;
        int draws = 0;

        for (int i = 0; i < ROLLS; i++) {
            int player1Score = playGame(sequence1);
            int player2Score = playGame(sequence2);

            if (player1Score > player2Score) {
                player1Wins++;
            } else if (player2Score > player1Score) {
                player2Wins++;
            } else {
                draws++;
            }
        }

        double player1WinRate = (double) player1Wins / ROLLS;
        double player2WinRate = (double) player2Wins / ROLLS;
        double drawRate = (double) draws / ROLLS;

        System.out.println("Player 1 win rate: " + player1WinRate);
        System.out.println("Player 2 win rate: " + player2WinRate);
        System.out.println("Draw rate: " + drawRate);
    }

    /**
     * Simulates a game for a given sequence.
     *
     * @param sequence the sequence that the player is trying to roll
     * @return the score for the game
     */
    public static int playGame(Integer[] sequence) {
        if (sequence == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (sequence.length != 3) {
            throw new IllegalArgumentException("Input array cannot be less or more than 3 elements");
        }

        int score = 0;
        int index = 0;

        for (int i = 0; i < ROLLS; i++) {
            int roll = RANDOM.nextInt(6) + 1;

            if (roll == sequence[index]) {
                index++;
                if (index == sequence.length) {
                    score++;
                    index = 0;
                }
            } else {
                index = 0;
            }
        }

        return score;
    }
}
