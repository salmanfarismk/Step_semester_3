package string.assigment_problems;

/**
 * Problem 3: The Traffic Signal Streak Analyzer
 * Scenario: City Traffic Control Department
 * 
 * Analyzes traffic signal reading sequences to detect the longest continuous
 * streak of identical signal color readings.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Finds and prints the longest continuous streak of the same signal reading.
     *
     * @param signalLog String of signal readings (e.g. "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data available.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);
            if (ch == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = ch;
                currentStreak = 1;
            }
        }

        // Final check for the last streak
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("=== City Traffic Signal Streak Analyzer ===");

        String test1 = "RRGGGYRR";
        System.out.print("\"" + test1 + "\" -> ");
        findLongestStreak(test1);

        String test2 = "RRRRYYGG";
        System.out.print("\"" + test2 + "\" -> ");
        findLongestStreak(test2);

        String test3 = "GYRRRGGYY";
        System.out.print("\"" + test3 + "\" -> ");
        findLongestStreak(test3);
    }
}
