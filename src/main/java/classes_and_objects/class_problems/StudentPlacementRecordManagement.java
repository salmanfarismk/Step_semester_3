package classes_and_objects.class_problems;

/**
 * Problem M1: Student Placement Record Management
 * Scenario: T&P Cell Placement Record Tracker
 * 
 * Replaces parallel arrays (names, companies, packages) with an object-oriented
 * approach using the PlacementRecord class to encapsulate student placement details.
 * 
 * Concepts: Class definition, constructors, instance methods, array of objects.
 */
public class StudentPlacementRecordManagement {

    /**
     * Encapsulates placement information for a single student.
     */
    public static class PlacementRecord {
        private final String studentName;
        private final String company;
        private final double packageLpa;

        /**
         * Constructor that initializes all three placement fields.
         *
         * @param studentName Name of the placed student
         * @param company     Company the student is placed in
         * @param packageLpa  Salary package in LPA
         */
        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        /**
         * Prints the placement record in the specified format:
         * "studentName -> company @ packageLpa LPA"
         */
        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M1: Student Placement Record Management ===");

        // Create three PlacementRecord objects
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Print each record in a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
