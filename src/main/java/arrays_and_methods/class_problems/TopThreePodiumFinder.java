package arrays_and_methods.class_problems;

import java.util.Arrays;

/**
 * Problem 3: Top-3 Podium Finder
 * Scenario: Instant Stage Podium Announcement
 * 
 * Identifies the top 3 scores for the podium finishers in a single pass
 * through the array without sorting, preserving ties.
 * 
 * Concepts: Single-pass tracking with three running variables, shift mechanics,
 * avoiding unnecessary sorting.
 */
public class TopThreePodiumFinder {

    /**
     * Finds the top 3 highest scores in descending order in a single pass.
     *
     * @param scores Array of team scores (length >= 3)
     * @return Array of top 3 scores [first, second, third]
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Scores array must contain at least 3 elements.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top-3 Podium Finder ===");

        // Sample 1
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input: " + Arrays.toString(scores1));
        System.out.println("Output: " + Arrays.toString(findTopThreeScores(scores1)));

        // Sample 2
        int[] scores2 = {10, 20, 30, 40, 50};
        System.out.println("\nInput: " + Arrays.toString(scores2));
        System.out.println("Output: " + Arrays.toString(findTopThreeScores(scores2)));

        // Sample 3 (All identical)
        int[] scores3 = {100, 100, 100, 95};
        System.out.println("\nInput: " + Arrays.toString(scores3));
        System.out.println("Output: " + Arrays.toString(findTopThreeScores(scores3)));
    }
}
