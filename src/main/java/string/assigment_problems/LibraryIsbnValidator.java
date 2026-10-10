package string.assigment_problems;

/**
 * Problem 4: Library ISBN Normalizer & Validator
 * Scenario: Library Book-Intake Scanner
 * 
 * Normalizes and validates 13-character ISBN-style inventory codes:
 * 3 letters (publisher code) + 4 digits (year) + 6 digits (catalog number).
 */
public class LibraryIsbnValidator {

    /**
     * Trims whitespace and uppercases the first 3 characters representing the publisher code.
     *
     * @param raw The raw scanned code
     * @return Normalized code string
     */
    public static String normalizeCode(String raw) {
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
     * Validates that the normalized code consists of 3 letters followed by 10 digits,
     * building a formatted display line with StringBuilder or reporting an error reason.
     *
     * @param code The normalized code string
     * @return Formatted display string or error message
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year).append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void processCode(String raw) {
        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Library ISBN Normalizer & Validator ===");
        processCode(" pen2026004251 ");
        processCode("12N2026004251");
        processCode("OXF202400123A");
        processCode("SHORT123");
    }
}
