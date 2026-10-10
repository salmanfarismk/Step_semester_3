package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Problem 3: Top Performer Tracker
 * Scenario: Fantasy League Weekly Recap
 * 
 * Computes the minimum score, maximum score, and the spread (max - min)
 * across player scores in a single pass without sorting the array.
 * 
 * Concepts: Single-pass min/max tracking, running variable comparison, avoiding unnecessary sorts.
 */
public class TopPerformerTracker {

    /**
     * Finds the minimum, maximum, and spread in a single pass.
     *
     * @param scores Array of player scores (length >= 2)
     * @return Formatted string containing Min, Max, and Spread
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Scores array must contain at least 2 elements.");
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top Performer Tracker ===");

        // Sample 1
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input: " + Arrays.toString(scores1));
        System.out.println("Output: " + findMinMaxSpread(scores1));

        // Sample 2
        int[] scores2 = {50, 50, 50};
        System.out.println("\nInput: " + Arrays.toString(scores2));
        System.out.println("Output: " + findMinMaxSpread(scores2));

        // Sample 3
        int[] scores3 = {15, 85};
        System.out.println("\nInput: " + Arrays.toString(scores3));
        System.out.println("Output: " + findMinMaxSpread(scores3));
    }
}
