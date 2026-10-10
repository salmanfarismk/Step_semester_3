package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Problem 2: Duplicate Player Pick Checker
 * Scenario: Fantasy Draft Screen Glitch Detector
 * 
 * Checks a submitted fantasy lineup for duplicate player selections using
 * plain nested loops without any Collections classes.
 * 
 * Concepts: Nested loops, pairwise comparison, string comparison, early exit.
 */
public class DuplicatePlayerPickChecker {

    /**
     * Checks if any player name appears more than once in the lineup.
     *
     * @param playerNames Array of player names in the lineup
     * @return "Duplicate Found: <name>" if a duplicate is found, otherwise "No Duplicates Found"
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Duplicate Player Pick Checker ===");

        // Sample 1
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Input: " + Arrays.toString(lineup1));
        System.out.println("Output: " + findDuplicatePick(lineup1));

        // Sample 2
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("\nInput: " + Arrays.toString(lineup2));
        System.out.println("Output: " + findDuplicatePick(lineup2));

        // Additional Test Case
        String[] lineup3 = {"Dhoni", "Jadeja", "Ashwin", "Dhoni"};
        System.out.println("\nInput: " + Arrays.toString(lineup3));
        System.out.println("Output: " + findDuplicatePick(lineup3));
    }
}
