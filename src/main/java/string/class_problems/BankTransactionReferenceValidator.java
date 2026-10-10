package string.class_problems;

/**
 * Problem 5: Bank Transaction Reference Generator & Validator
 * Scenario: Fintech Onboarding Reference Validation
 * 
 * Normalizes and validates 14-character transaction reference codes:
 * 3 letters (bank code) + 6 digits (date: ddMMyy) + 5 digits (sequence number).
 */
public class BankTransactionReferenceValidator {

    /**
     * Trims spaces and uppercases the first 3 characters of the reference code.
     *
     * @param raw The raw reference code with potential whitespace and mixed casing
     * @return Normalized reference string
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates that the normalized code has 3 letters and 11 digits,
     * formatting valid codes with StringBuilder or reporting the failure reason.
     *
     * @param reference The normalized reference code
     * @return Formatted reference string or descriptive error message
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        // Build formatted representation with StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        sb.append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void processReference(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Fintech Reference Normalizer & Validator ===");
        processReference(" hdf03022600042 ");
        processReference("12F03022600042");
        processReference("SBI0302260004A");
        processReference("ICICI123");
    }
}
