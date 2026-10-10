package string.assigment_problems;

/**
 * Problem 1: The Exam Hall Seat Duplication Checker
 * Scenario: The Examination Cell
 * 
 * Scans an array of assigned seat numbers to flag duplicate allocations
 * using nested loops and primitive arrays (no Collections classes).
 */
public class ExamHallSeatDuplicationChecker {

    /**
     * Checks an array of seat numbers for duplicate assignments without using Collections.
     *
     * @param seatNumbers Array of assigned seat numbers
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seats assigned.");
            return;
        }

        boolean duplicateFound = false;
        // Array to keep track of duplicates already printed to avoid duplicate output
        boolean[] alreadyReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }

            boolean isCurrentDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isCurrentDuplicate = true;
                    alreadyReported[j] = true;
                }
            }

            if (isCurrentDuplicate) {
                duplicateFound = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Examination Cell: Seat Duplication Checker ===");

        int[] sample1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105} -> Output: ");
        checkDuplicateSeats(sample1);

        int[] sample2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105} -> Output: ");
        checkDuplicateSeats(sample2);
    }
}
