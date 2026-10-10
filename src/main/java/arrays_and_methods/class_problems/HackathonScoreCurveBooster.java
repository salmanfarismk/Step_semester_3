package arrays_and_methods.class_problems;

import java.util.Arrays;

/**
 * Problem 1: Hackathon Score Curve Booster
 * Scenario: Campus Hackathon Leaderboard Calibration
 * 
 * The judging panel at a campus hackathon realizes the coding round was tougher
 * than intended, and wants to give every team a flat bonus before the final
 * leaderboard is printed. Modifies scores in place directly via array reference.
 * 
 * Concepts: Modifying arrays passed by reference, in-place update, Arrays.toString() formatting.
 */
public class HackathonScoreCurveBooster {

    /**
     * Curves every score in the caller's array directly by adding the bonus amount in place.
     *
     * @param scores The array of team scores to modify in place
     * @param bonus  The flat bonus points to add to each score
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null || bonus < 0) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Hackathon Score Curve Booster ===");

        // Sample 1
        int[] scores1 = {70, 85, 60};
        System.out.println("Before Curve: " + Arrays.toString(scores1));
        curveScores(scores1, 10);
        System.out.println("After Curve (+10): " + Arrays.toString(scores1));

        // Sample 2
        int[] scores2 = {45, 92, 78, 55};
        System.out.println("\nBefore Curve: " + Arrays.toString(scores2));
        curveScores(scores2, 5);
        System.out.println("After Curve (+5): " + Arrays.toString(scores2));
    }
}
