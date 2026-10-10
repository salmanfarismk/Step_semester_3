package classes_and_objects.class_problems;

/**
 * Problem M2: Hostel Mess Wallet Management
 * Scenario: Hostel Mess-Card Wallet
 * 
 * Protects a student's mess wallet balance from invalid states using encapsulation:
 * prevents negative balances, validates top-ups and deductions, and restricts balance mutations.
 * 
 * Concepts: Encapsulation, private fields, getter methods, business logic validation.
 */
public class HostelMessWalletManagement {

    /**
     * Represents a student's hostel mess card wallet.
     */
    public static class MessWallet {
        private double balance;

        /**
         * Constructor that initializes opening balance, falling back to 0 if negative.
         *
         * @param openingBalance Initial wallet balance
         */
        public MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: Opening balance cannot be negative. Initializing to 0.0.");
                this.balance = 0.0;
            } else {
                this.balance = openingBalance;
            }
        }

        /**
         * Adds funds to the wallet balance. Rejects non-positive amounts.
         *
         * @param amount Amount to top up
         */
        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be greater than zero.");
                return;
            }
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }

        /**
         * Deducts funds from the wallet. Rejects if balance is insufficient.
         *
         * @param amount Amount to deduct
         */
        public void deduct(double amount) {
            if (amount <= 0) {
                System.out.println("Deduct rejected: amount must be greater than zero.");
                return;
            }
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            balance -= amount;
        }

        /**
         * Read-only access to current balance.
         *
         * @return Current balance
         */
        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M2: Hostel Mess Wallet Management ===");

        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
