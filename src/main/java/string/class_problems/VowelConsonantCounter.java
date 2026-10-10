package string.class_problems;

/**
 * Problem 1: Vowel & Consonant Counter
 * Scenario: Library Orientation Kiosk
 * 
 * Counts vowels and consonants in a text string case-insensitively,
 * ignoring whitespace characters.
 */
public class VowelConsonantCounter {

    /**
     * Loops through each character using charAt(), counts vowels and consonants separately,
     * and prints the result.
     *
     * @param text The input string to analyze
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        System.out.println("=== Library Orientation Kiosk: Text Stats ===");

        String sample1 = "Java Programming";
        System.out.println("Input: \"" + sample1 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(sample1);

        String sample2 = "Hello World";
        System.out.println("\nInput: \"" + sample2 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(sample2);
    }
}
