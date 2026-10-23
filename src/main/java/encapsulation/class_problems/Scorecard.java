package encapsulation.class_problems;

/**
 * Problem 2: The Quiz Scorecard
 * Scenario: Quiz App Secret Scorekeeping
 * 
 * Demonstrates information hiding by encapsulating raw right/wrong quiz answers
 * inside a private array and only exposing computed summary metrics (total score).
 * Prevents outside access or leakage of individual question results.
 * 
 * Concepts: Information hiding, array encapsulation, computed getters.
 */
public class Scorecard {

    private final boolean[] answers;
    private final int totalQuestions;
    private int recordedCount;

    /**
     * Initializes the scorecard with a fixed number of questions.
     *
     * @param totalQuestions Total number of questions in the quiz
     */
    public Scorecard(int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new IllegalArgumentException("Total questions must be greater than zero.");
        }
        this.totalQuestions = totalQuestions;
        this.answers = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    /**
     * Records the outcome of the next question.
     *
     * @param result true for correct, false for incorrect
     */
    public void recordAnswer(boolean result) {
        if (recordedCount < totalQuestions) {
            answers[recordedCount] = result;
            recordedCount++;
        } else {
            System.out.println("Rejected: All " + totalQuestions + " questions have already been recorded.");
        }
    }

    /**
     * Computes and returns the total score (count of correct answers).
     * The internal answers array is never exposed.
     *
     * @return Number of correct answers
     */
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    /**
     * Returns the total questions count.
     *
     * @return Total questions in this scorecard
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }

    /**
     * Returns the number of answers recorded so far.
     *
     * @return Recorded questions count
     */
    public int getRecordedCount() {
        return recordedCount;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Quiz Scorecard ===");

        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());

        // Attempting to record beyond total questions
        sc.recordAnswer(true);
    }
}
