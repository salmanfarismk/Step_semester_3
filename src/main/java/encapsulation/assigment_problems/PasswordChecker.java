package encapsulation.assigment_problems;

/**
 * Problem 3: The Password Checker
 * Scenario: Account Signup Password Strength Evaluator
 * 
 * Demonstrates complete read-hiding of sensitive data: accepts and stores
 * a password as an immutable private field with zero getter methods,
 * exposing only an evaluated strength rating.
 * 
 * Concepts: Sensitive data protection, non-disclosure of internal state, computed evaluation.
 */
public class PasswordChecker {

    private final String password;

    /**
     * Initializes the PasswordChecker with the given password string.
     * The password itself is locked permanently and never exposed.
     *
     * @param password The password to evaluate
     */
    public PasswordChecker(String password) {
        this.password = (password == null) ? "" : password;
    }

    /**
     * Evaluates and returns the strength rating of the password:
     * - "Weak": under 6 characters
     * - "Medium": 6 to 9 characters
     * - "Strong": 10 or more characters
     *
     * @return Strength classification label
     */
    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Password Checker ===");

        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Password \"abcd\" -> pc1.getStrength() = " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Password \"abcdefgh\" -> pc2.getStrength() = " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Password \"abcdefghij\" -> pc3.getStrength() = " + pc3.getStrength());
    }
}
