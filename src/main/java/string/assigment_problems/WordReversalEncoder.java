package string.assigment_problems;

/**
 * Problem 2: Word Reversal Encoder
 * Scenario: Mirror Text Mini-Game
 * 
 * Reverses every word in a sentence individually while maintaining
 * the original sentence word sequence.
 */
public class WordReversalEncoder {

    /**
     * Reverses each word in the sentence using a loop and StringBuilder,
     * joining them back with single spaces.
     *
     * @param sentence The input sentence
     * @return Transformed string with each word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            String currentWord = words[i];

            // Reverse using a loop as specified
            for (int j = currentWord.length() - 1; j >= 0; j--) {
                reversedWord.append(currentWord.charAt(j));
            }

            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Coding Club: Word Reversal Encoder ===");

        String sentence1 = "hello club";
        System.out.println("Input: \"" + sentence1 + "\" -> Output: " + reverseEachWord(sentence1));

        String sentence2 = "data structures and algorithms";
        System.out.println("Input: \"" + sentence2 + "\" -> Output: " + reverseEachWord(sentence2));
    }
}
