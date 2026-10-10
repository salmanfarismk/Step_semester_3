package string.class_problems;

/**
 * Problem 4: Masked Phone Number Formatter
 * Scenario: Student-Support Call Center
 * 
 * Formats a 10-digit phone number with masking for privacy (XXXXXX-XXXX),
 * validating length and digit contents.
 */
public class MaskedPhoneNumberFormatter {

    /**
     * Validates and masks a 10-digit phone number using StringBuilder.
     *
     * @param phone The input phone number string
     * @return Formatted masked phone number string or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build masked representation with StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6)); // last 4 digits

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Student-Support Call Center: Phone Masking ===");

        String phone1 = "9876543210";
        System.out.println("Input: \"" + phone1 + "\" -> Output: " + maskPhoneNumber(phone1));

        String phone2 = "98765";
        System.out.println("Input: \"" + phone2 + "\" -> Output: " + maskPhoneNumber(phone2));

        String phone3 = "987654ABCD";
        System.out.println("Input: \"" + phone3 + "\" -> Output: " + maskPhoneNumber(phone3));
    }
}
