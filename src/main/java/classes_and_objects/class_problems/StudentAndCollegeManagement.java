package classes_and_objects.class_problems;

/**
 * Problem M5: Student and College Information Management
 * Scenario: Shared Campus Metadata Architecture
 * 
 * Demonstrates the use of static fields and static methods to avoid duplicate memory
 * allocation across instances for shared university-level attributes and global instance counters.
 * 
 * Concepts: Static variables, instance variables, static methods, class-level invocation.
 */
public class StudentAndCollegeManagement {

    /**
     * Represents a student enrolled at the university.
     */
    public static class Student {
        // Instance fields (unique per student)
        private final String name;
        private double attendance;

        // Static fields (shared across all student instances)
        public static String collegeName = "SRM Institute of Science and Technology";
        public static int studentCount = 0;

        /**
         * Constructor initializing individual student data and incrementing global counter.
         *
         * @param name       Student's full name
         * @param attendance Attendance percentage
         */
        public Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++; // Increment global instance counter
        }

        public String getName() {
            return name;
        }

        public double getAttendance() {
            return attendance;
        }

        public void setAttendance(double attendance) {
            this.attendance = attendance;
        }

        /**
         * Static method that prints college-wide statistics without referencing instance fields.
         */
        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M5: Student and College Information Management ===");

        // Create two Student objects
        Student s1 = new Student("Aakash", 88.5);
        Student s2 = new Student("Bhavna", 92.0);

        // Call printCollegeInfo() strictly through the class name
        Student.printCollegeInfo();
    }
}
