package classes_and_objects.assigment_problems;

/**
 * Problem M5: Employee and Company Information Management
 * Scenario: Corporate Enterprise Identity Architecture
 * 
 * Replaces redundant per-instance company name fields with a single class-level static field,
 * and maintains an accurate head-count tracking metric via a static employeeCount variable.
 * 
 * Concepts: Static vs instance variables, class-level encapsulation, static methods.
 */
public class EmployeeAndCompanyManagement {

    /**
     * Represents a corporate employee.
     */
    public static class Employee {
        // Instance fields (unique per employee)
        private final String empName;
        private final double salary;

        // Static fields (shared by all employees of the company)
        public static String companyName = "Bright Horizon Technologies";
        public static int employeeCount = 0;

        /**
         * Constructor initializing individual employee data and incrementing global counter.
         *
         * @param empName Name of the employee
         * @param salary  Compensation of the employee
         */
        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++; // Increment global headcount
        }

        public String getEmpName() {
            return empName;
        }

        public double getSalary() {
            return salary;
        }

        /**
         * Static method that displays global company statistics without referencing instance fields.
         */
        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M5: Employee and Company Information Management ===");

        // Create three Employee objects
        Employee emp1 = new Employee("Rajesh", 70000);
        Employee emp2 = new Employee("Sneha", 85000);
        Employee emp3 = new Employee("Vikas", 60000);

        // Call printCompanyInfo() strictly through the class name
        Employee.printCompanyInfo();
    }
}
