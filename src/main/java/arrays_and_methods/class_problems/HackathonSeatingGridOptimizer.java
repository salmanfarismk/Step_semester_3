package arrays_and_methods.class_problems;

/**
 * Problem 4: Hackathon Seating Grid Optimizer
 * Scenario: Floor Mentor Dispatch Grid
 * 
 * Classifies each row in a seating grid as either a "Quiet Zone" (struggling,
 * average below threshold) or "Buzzing Zone" (performing well, average at or above threshold)
 * using a reusable rowAverage helper method.
 * 
 * Concepts: 2D arrays, jagged array handling, helper method extraction, loop classification.
 */
public class HackathonSeatingGridOptimizer {

    /**
     * Calculates the average score of a single row.
     *
     * @param row Array of scores in a specific row
     * @return Average score of the row, or 0.0 if row is empty
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    /**
     * Classifies each seating row based on whether its average score meets the threshold.
     *
     * @param seatingScores 2D array representing seating rows
     * @param threshold     Score threshold for a Buzzing Zone
     * @return Formatted classification string for all rows
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Hackathon Seating Grid Optimizer ===");

        // Sample 1
        int[][] seatingScores1 = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold1 = 60;
        System.out.println("Threshold = " + threshold1);
        System.out.println("Output: " + classifyRows(seatingScores1, threshold1));

        // Sample 2 (Jagged Rows)
        int[][] seatingScores2 = {
            {55, 65},
            {70, 80, 90, 85},
            {20}
        };
        int threshold2 = 65;
        System.out.println("\nThreshold = " + threshold2);
        System.out.println("Output: " + classifyRows(seatingScores2, threshold2));
    }
}
