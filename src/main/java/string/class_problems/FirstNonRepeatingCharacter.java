package string.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem 4: First Non-Repeating Character
 * Scenario: The Unique Letter Hunt Mini-Game
 * 
 * Computes the character frequency of an input string and finds
 * the first character whose frequency is exactly 1.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Scans the string to find the first character with a frequency of exactly 1.
     *
     * @param text The input string to inspect
     * @return The first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Count character frequencies using an array for standard ASCII or Map
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                freq[ch]++;
            }
        }

        // Scan from left to right to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && freq[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    /**
     * Tests an input string and prints the result matching the required output format.
     */
    public static void test(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.printf("\"%s\" -> First Non-Repeating Character: '%c'%n", text, result);
        } else {
            System.out.printf("\"%s\" -> No Non-Repeating Character Found%n", text);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game ===");
        test("swiss");
        test("aabbcc");
        test("stress");
        test("character");
    }
}
