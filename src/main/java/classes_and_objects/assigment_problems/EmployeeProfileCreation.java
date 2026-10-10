package classes_and_objects.assigment_problems;

/**
 * Problem M3: Employee Profile Creation
 * Scenario: Corporate Onboarding Profile Management
 * 
 * Demonstrates constructor overloading and chaining using this(...) to handle
 * different categories of employees (permanent staff vs interns) cleanly without code duplication.
 * 
 * Concepts: Constructor overloading, this(...) constructor chaining, boolean flags.
 */
public class EmployeeProfileCreation {

    /**
     * Represents an employee profile record.
     */
    public static class Employee {
        private final String empId;
        private final String empName;
        private final double salary;
        private boolean isIntern;

        /**
         * Constructor for permanent employees with predetermined salary.
         *
         * @param empId   Unique employee ID
         * @param empName Full name of the employee
         * @param salary  Monthly or annual compensation
         */
        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        /**
         * Constructor for interns who do not yet have a fixed salary structure.
         * Chains to the 3-parameter constructor with salary 0, then sets isIntern to true.
         *
         * @param empId   Unique intern ID
         * @param empName Full name of the intern
         */
        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        /**
         * Prints the employee profile details on a single formatted line.
         */
        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M3: Employee Profile Creation ===");

        // Permanent employee
        Employee permanentEmp = new Employee("E-101", "Divya", 65000);
        permanentEmp.printProfile();

        // Intern employee (chains via this(...))
        Employee internEmp = new Employee("E-102", "Arjun");
        internEmp.printProfile();
    }
}
