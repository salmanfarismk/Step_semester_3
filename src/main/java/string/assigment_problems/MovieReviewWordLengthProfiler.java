package string.assigment_problems;

/**
 * Problem 5: The Movie Review Word Length Profiler
 * Scenario: Movie-Review Content Moderation Tool
 * 
 * Splits review text into tokens, categorizes words based on character length
 * (Short: 1-4, Medium: 5-8, Long: 9+), and reports frequency counts.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits a review into words, categorizes word lengths, and prints the summary breakdown.
     *
     * @param review Raw text of the movie review
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split by whitespace
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Strip out surrounding punctuation if present for pure word length
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int len = cleanWord.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n",
                shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Movie Review Word Length Profiler ===");

        String review1 = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review1 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review1);

        String review2 = "An extraordinary cinematic masterpiece with incredible visuals";
        System.out.println("\nInput: \"" + review2 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review2);
    }
}
