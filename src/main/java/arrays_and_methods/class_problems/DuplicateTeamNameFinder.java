package arrays_and_methods.class_problems;

import java.util.Arrays;

/**
 * Problem 2: Duplicate Team Name Finder
 * Scenario: Hackathon Registration Audit
 * 
 * Scans the list of registered team names and reports the first duplicate
 * team name found using plain nested loops without using any Collections classes.
 * 
 * Concepts: Plain nested loops, pairwise comparison, string equality, early exit.
 */
public class DuplicateTeamNameFinder {

    /**
     * Finds the first duplicate team name in the list.
     *
     * @param teamNames Array of registered team names
     * @return "Duplicate Found: <name>" if a duplicate is found, otherwise "No Duplicates Found"
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Duplicate Team Name Finder ===");

        // Sample 1
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Input: " + Arrays.toString(teams1));
        System.out.println("Output: " + findDuplicateTeam(teams1));

        // Sample 2
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("\nInput: " + Arrays.toString(teams2));
        System.out.println("Output: " + findDuplicateTeam(teams2));

        // Additional Test Case
        String[] teams3 = {"Alpha", "Beta", "Gamma", "Beta", "Alpha"};
        System.out.println("\nInput: " + Arrays.toString(teams3));
        System.out.println("Output: " + findDuplicateTeam(teams3));
    }
}
