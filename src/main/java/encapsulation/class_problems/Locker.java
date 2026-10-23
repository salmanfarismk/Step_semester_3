package encapsulation.class_problems;

/**
 * Problem 4: The Locker Code
 * Scenario: Gym Locker Combination Security
 * 
 * Demonstrates write-only encapsulation where a sensitive attribute (combination code)
 * can be modified under strict authorization (validating the current code first)
 * but cannot be read or retrieved from outside the class.
 * 
 * Concepts: Write-only attributes, access control, credential authentication, state protection.
 */
public class Locker {

    private final int lockerNumber;
    private String combinationCode;

    /**
     * Initializes the locker with a permanent locker number and an initial code.
     *
     * @param lockerNumber    Permanent locker identifier
     * @param combinationCode Initial combination code
     */
    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    /**
     * Changes the combination code only if the current code matches.
     *
     * @param oldCode Current code entered for verification
     * @param newCode New combination code to set
     * @return true if changed successfully, false if rejected
     */
    public boolean changeCode(String oldCode, String newCode) {
        if (this.combinationCode != null && this.combinationCode.equals(oldCode)) {
            this.combinationCode = newCode;
            System.out.println("Locker " + lockerNumber + " code change -> success");
            return true;
        } else {
            System.out.println("Locker " + lockerNumber + " code change -> rejected (invalid current code)");
            return false;
        }
    }

    /**
     * Read-only getter for locker number.
     * Note: No getter is provided for combinationCode to maintain complete confidentiality.
     *
     * @return Permanent locker number
     */
    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Locker Code ===");

        Locker l = new Locker(101, "1234");
        System.out.println("Locker Number: " + l.getLockerNumber());

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
        l.changeCode("5678", "4321");
    }
}
