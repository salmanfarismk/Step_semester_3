package arrays_and_methods.assigment_problems;

/**
 * Problem 4: Match Day Grid Analyzer
 * Scenario: Cricket Power Surge Innings Classifier
 * 
 * Analyzes runs per over across matches and classifies each match as
 * "Power Surge" (average >= threshold) or "Normal" (< threshold) using
 * a reusable helper method.
 * 
 * Concepts: 2D arrays, jagged rows, helper method extraction, loop classification.
 */
public class MatchDayGridAnalyzer {

    /**
     * Calculates the average run rate for a single match (row).
     *
     * @param row Array of runs scored per over in a match
     * @return Average runs per over, or 0.0 if row is empty
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    /**
     * Classifies each match into "Power Surge" or "Normal" based on the threshold.
     *
     * @param runsPerOver 2D array of runs per over for each match
     * @param threshold   Scoring rate threshold
     * @return Formatted classification string for all matches
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(status);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Match Day Grid Analyzer ===");

        // Sample 1
        int[][] runs1 = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold1 = 8;
        System.out.println("Threshold = " + threshold1);
        System.out.println("Output: " + classifyMatches(runs1, threshold1));

        // Sample 2 (Jagged match lengths)
        int[][] runs2 = {
            {6, 12, 15, 18},
            {2, 4},
            {8, 8, 8}
        };
        int threshold2 = 8;
        System.out.println("\nThreshold = " + threshold2);
        System.out.println("Output: " + classifyMatches(runs2, threshold2));
    }
}
