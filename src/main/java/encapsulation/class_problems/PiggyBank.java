package encapsulation.class_problems;

/**
 * Problem 1: The Piggy Bank
 * Scenario: Kid's Savings App
 * 
 * Demonstrates basic encapsulation where monetary balance cannot be set
 * directly to arbitrary values from outside the class. Money can only be
 * deposited or withdrawn with boundary validation, and the piggy bank has
 * an immutable final ID.
 * 
 * Concepts: Encapsulation, private state, final fields, defensive validation.
 */
public class PiggyBank {

    private final String id;
    private int savings;

    /**
     * Initializes the piggy bank with an immutable ID and starts savings at 0.
     *
     * @param id Unique identifier for the piggy bank
     */
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    /**
     * Deposits money into the piggy bank.
     *
     * @param amount The amount to deposit (must be positive)
     */
    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposited " + amount + " -> savings = " + savings);
        } else {
            System.out.println("Deposit rejected: amount must be positive");
        }
    }

    /**
     * Withdraws money from the piggy bank if sufficient balance is present.
     *
     * @param amount The amount to withdraw
     */
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive");
            return;
        }

        if (amount > savings) {
            System.out.println("Withdrawal of " + amount + " rejected, savings stays " + savings);
        } else {
            savings -= amount;
            System.out.println("Withdrew " + amount + " -> savings = " + savings);
        }
    }

    /**
     * Read-only getter for current savings.
     *
     * @return Current amount saved
     */
    public int getSavings() {
        return savings;
    }

    /**
     * Read-only getter for piggy bank ID.
     *
     * @return Piggy bank ID
     */
    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Piggy Bank ===");

        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("PiggyBank ID: " + pb.getId() + ", Initial savings: " + pb.getSavings());

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final savings: " + pb.getSavings());
    }
}
