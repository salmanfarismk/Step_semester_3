package string.assigment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Problem 5: Stop-Word-Filtered Word Frequency Report
 * Scenario: T&P Feedback Text Moderation & Analysis
 * 
 * Cleans feedback text by removing punctuation and stop words,
 * counts word occurrences, and prints frequencies sorted in descending order.
 */
public class StopWordFilteredWordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>();

    static {
        Collections.addAll(STOP_WORDS, "the", "was", "and", "a", "is", "of", "in");
    }

    /**
     * Normalizes text, filters stop words, computes word frequencies,
     * and prints sorted results.
     *
     * @param feedback Raw feedback text
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Convert to lowercase and strip punctuation using replace()
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "")
                .replace("\"", "");

        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stop-Word-Filtered Word Frequency Report ===");

        String feedback = "The mentor was great, the session was great and clear.";
        System.out.println("Input: \"" + feedback + "\"");
        System.out.println("Output:");
        printFilteredWordFrequency(feedback);
    }
}
