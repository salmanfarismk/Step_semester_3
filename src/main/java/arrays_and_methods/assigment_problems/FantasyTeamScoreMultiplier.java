package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Problem 1: Fantasy Team Score Multiplier
 * Scenario: Fantasy Sports Lineup Booster
 * 
 * Applies multiplier bonuses directly to the caller's score array:
 * Captain receives 2.0x points, and Vice-Captain receives 1.5x points.
 * 
 * Concepts: Modifying arrays passed by reference, direct index access, in-place update.
 */
public class FantasyTeamScoreMultiplier {

    /**
     * Applies captain (2x) and vice-captain (1.5x) multipliers directly in place.
     *
     * @param playerScores      Array of player scores to modify
     * @param captainIndex      Index of the chosen captain
     * @param viceCaptainIndex  Index of the chosen vice-captain
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        // Apply multipliers directly to the specific positions
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fantasy Team Score Multiplier ===");

        // Sample 1
        double[] scores1 = {40, 55, 30, 62};
        System.out.println("Original Scores: " + Arrays.toString(scores1));
        applyMultipliers(scores1, 1, 3);
        System.out.println("Boosted Scores: " + Arrays.toString(scores1));

        // Sample 2
        double[] scores2 = {100, 50, 75};
        System.out.println("\nOriginal Scores: " + Arrays.toString(scores2));
        applyMultipliers(scores2, 0, 2);
        System.out.println("Boosted Scores: " + Arrays.toString(scores2));
    }
}
