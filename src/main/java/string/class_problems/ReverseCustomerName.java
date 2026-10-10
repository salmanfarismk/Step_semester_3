package string.class_problems;

/**
 * Problem 5: Reverse Customer Name
 * Scenario: The Customer Identity Verification System
 * 
 * Reverses a customer's name character sequence without modifying the original data.
 */
public class ReverseCustomerName {

    /**
     * Reverses the given customer name while preserving character casing.
     *
     * @param customerName The original customer name string
     * @return The reversed name string
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===");

        String[] testNames = {"Sunil", "Alice", "Robert", "Samantha"};

        for (String name : testNames) {
            String reversed = reverseCustomerName(name);
            System.out.println("Original Name: " + name);
            System.out.println("Reversed Name: " + reversed);
            System.out.println();
        }
    }
}
