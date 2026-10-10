package string.class_problems;

/**
 * Problem 2: CSV Student Record Parser
 * Scenario: T&P Student Registration Parser
 * 
 * Parses comma-separated student records, validates field counts,
 * and formats the output.
 */
public class CsvStudentRecordParser {

    /**
     * Splits a CSV line by comma, validates for exactly 3 fields,
     * and displays formatted student details.
     *
     * @param csvLine The raw CSV string ("Name,RollNumber,Department")
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNo, dept);
    }

    public static void main(String[] args) {
        System.out.println("=== T&P Student Record Parser ===");

        String record1 = "Ananya Verma,RA2211003010123,CSE";
        System.out.println("Input: \"" + record1 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(record1);

        String record2 = "Ananya Verma,CSE";
        System.out.println("\nInput: \"" + record2 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(record2);
    }
}
