package string.assigment_problems;

/**
 * Problem 1: ATM PIN Length Validator
 * Scenario: ATM Application Input Validation
 * 
 * Verifies that a user-entered PIN is exactly 4 digits long using
 * the length() method and a single conditional check.
 */
public class AtmPinLengthValidator {

    /**
     * Checks if the given PIN has a length of exactly 4 characters.
     *
     * @param pin The PIN string entered by the user
     */
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ATM PIN Length Validator ===");

        String pin1 = "482";
        System.out.print("Input: \"" + pin1 + "\" -> Output: ");
        checkPinLength(pin1);

        String pin2 = "4820";
        System.out.print("Input: \"" + pin2 + "\" -> Output: ");
        checkPinLength(pin2);
    }
}
