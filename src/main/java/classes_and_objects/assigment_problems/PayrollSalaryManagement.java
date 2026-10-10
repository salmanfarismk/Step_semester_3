package classes_and_objects.assigment_problems;

/**
 * Problem M2: Payroll Salary Management
 * Scenario: Corporate Payroll Account System
 * 
 * Protects salary calculations using object encapsulation: ensures bonuses cannot be negative,
 * validates tax deductions within the 0-100% range, and restricts direct modification of net salary.
 * 
 * Concepts: Encapsulation, private fields, input validation, state mutation methods.
 */
public class PayrollSalaryManagement {

    /**
     * Represents a payroll account for an employee.
     */
    public static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        /**
         * Constructor initializing basic salary, defaulting to 0 if negative.
         *
         * @param basicSalary Initial basic salary
         */
        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Warning: Basic salary cannot be negative. Initializing to 0.0.");
                this.basicSalary = 0.0;
            } else {
                this.basicSalary = basicSalary;
            }
            this.bonus = 0.0;
        }

        /**
         * Credits a bonus amount to the employee's payroll.
         *
         * @param amount Bonus amount to add
         */
        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus credit rejected: amount must be greater than zero.");
                return;
            }
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }

        /**
         * Deducts tax percentage from the basic salary.
         *
         * @param percent Tax deduction percentage (0 - 100)
         */
        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax deduction rejected: percentage must be between 0 and 100.");
                return;
            }
            this.basicSalary -= this.basicSalary * (percent / 100.0);
            System.out.println("Tax deducted: " + (int) percent + "%");
        }

        /**
         * Returns the computed net salary (basic salary + bonus).
         *
         * @return Total net salary
         */
        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M2: Payroll Salary Management ===");

        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
