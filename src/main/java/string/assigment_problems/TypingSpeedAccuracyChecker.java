package string.assigment_problems;

/**
 * Problem 2: The Typing Speed Test Accuracy Checker
 * Scenario: Online Typing-Practice Platform
 * 
 * Compares typed text character-by-character against the original text,
 * calculates accuracy percentage, and highlights the first mismatch.
 */
public class TypingSpeedAccuracyChecker {

    /**
     * Compares original text against user typed text and outputs accuracy statistics.
     *
     * @param original The expected reference passage
     * @param typed    The user's typed submission
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings provided.");
            return;
        }

        int total = original.length();
        int compareLength = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = '\0';
        char typedChar = '\0';

        for (int i = 0; i < compareLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-based position
                    origChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }

        // Account for length discrepancies if strings are not equal in length
        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = compareLength + 1;
            origChar = (original.length() > compareLength) ? original.charAt(compareLength) : ' ';
            typedChar = (typed.length() > compareLength) ? typed.charAt(compareLength) : ' ';
        }

        double accuracy = (total > 0) ? ((double) matched / total) * 100.0 : 0.0;

        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, total, accuracy, firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Typing Speed Test Accuracy Checker ===");

        String original1 = "hello world";
        String typed1 = "hello worlt";
        System.out.println("Input: original=\"" + original1 + "\", typed=\"" + typed1 + "\"");
        checkTypingAccuracy(original1, typed1);

        String original2 = "coding";
        String typed2 = "coding";
        System.out.println("Input: original=\"" + original2 + "\", typed=\"" + typed2 + "\"");
        checkTypingAccuracy(original2, typed2);
    }
}
