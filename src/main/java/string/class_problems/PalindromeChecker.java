package string.class_problems;

/**
 * Problem 2: Palindrome Checker (3 Approaches)
 * Scenario: The QA Text Verification Toolkit
 * 
 * Verifies a string using three independent palindrome detection algorithms:
 * 1. Iterative comparison (two-pointer approach)
 * 2. Recursive comparison
 * 3. Array reversal comparison
 */
public class PalindromeChecker {

    /**
     * Approach 1: Iterative check comparing characters from both ends moving inward.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check comparing first and last characters.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return checkRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean checkRecursiveHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return checkRecursiveHelper(text, left + 1, right - 1);
    }

    /**
     * Approach 3: Array-reversal check converting string to char array, reversing, and comparing.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Evaluates all three approaches and prints their results formatted as required.
     */
    public static void testAndPrint(String text) {
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        String iterResult = iterative ? "Palindrome" : "Not Palindrome";
        String recurResult = recursive ? "Palindrome" : "Not Palindrome";
        String arrResult = arrayReversal ? "Palindrome" : "Not Palindrome";

        System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                text, iterResult, recurResult, arrResult);
    }

    public static void main(String[] args) {
        System.out.println("=== QA Text Verification Toolkit: Palindrome Checker ===");
        testAndPrint("madam");
        testAndPrint("hello");
        testAndPrint("racecar");
        testAndPrint("step");
    }
}
