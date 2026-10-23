package encapsulation.class_problems;

/**
 * Problem 5: The Attendance Sheet
 * Scenario: Classroom Attendance Auditor
 * 
 * Demonstrates internal collection encapsulation. Stores present student names
 * in a private array without allowing outside callers to retrieve or modify
 * the underlying array, exposing only lookup queries and aggregate counters.
 * 
 * Concepts: Encapsulation of collections, duplicate suppression, query methods.
 */
public class AttendanceSheet {

    private final String[] presentStudents;
    private int count;

    /**
     * Initializes the attendance sheet with a fixed maximum class capacity.
     *
     * @param maxClassSize Maximum number of students that can be recorded
     */
    public AttendanceSheet(int maxClassSize) {
        if (maxClassSize <= 0) {
            throw new IllegalArgumentException("Class size must be positive.");
        }
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    /**
     * Marks a student present if they are not already recorded and capacity allows.
     *
     * @param name Name of the student
     */
    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }

        // Check if student is already marked present to avoid duplicates
        if (isPresent(name)) {
            return;
        }

        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        } else {
            System.out.println("Attendance capacity reached. Cannot mark " + name + " present.");
        }
    }

    /**
     * Returns the total count of distinct present students.
     *
     * @return Number of students marked present
     */
    public int getPresentCount() {
        return count;
    }

    /**
     * Checks whether a specific student is marked present.
     *
     * @param name Name of the student to look up
     * @return true if the student is present, false otherwise
     */
    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (presentStudents[i] != null && presentStudents[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Attendance Sheet ===");

        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate attempt

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
