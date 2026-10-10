package string.class_problems;

/**
 * Problem 3: BMI Calculator for a Team
 * Scenario: The Corporate Wellness Program
 * 
 * Computes BMI metrics and classifies wellness status for a team of employees.
 */
public class BmiCalculator {

    /**
     * Classifies health status based on standard BMI thresholds:
     * - BMI < 18.5 -> Underweight
     * - 18.5 <= BMI < 25.0 -> Normal (18.5-24.9)
     * - 25.0 <= BMI < 30.0 -> Overweight (25-29.9)
     * - BMI >= 30.0 -> Obese
     *
     * @param bmi Computed Body Mass Index
     * @return Classification category as String
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Prints a formatted wellness report for an array of employee heights and weights.
     *
     * @param heights Array of heights in meters
     * @param weights Array of weights in kilograms
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid team health records provided.");
            return;
        }

        System.out.println("\n----------------------------- Corporate Wellness Report -----------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = (h > 0) ? (w / (h * h)) : 0.0;
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-12s%n",
                    (i + 1), h, w, bmi, status);
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Corporate Wellness Program: BMI Calculator ===");

        // Sample data for 10 team members
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.62};
        double[] weights = {70.0, 90.0, 68.0, 85.0, 52.0, 42.0, 95.0, 65.0, 78.0, 58.0};

        // Demonstrating sample case outputs directly
        for (int i = 0; i < 2; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d — Height: %.2f m, Weight: %.0f kg -> BMI: %.2f | Status: %s%n",
                    (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }

        // Full report for the team
        printWellnessReport(heights, weights);
    }
}
