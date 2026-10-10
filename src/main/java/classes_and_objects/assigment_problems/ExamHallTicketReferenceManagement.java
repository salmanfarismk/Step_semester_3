package classes_and_objects.assigment_problems;

/**
 * Problem M4: Exam Hall Ticket Reference Management
 * Scenario: Examination Hall Ticket Pointer Verification
 * 
 * Demonstrates Java reference semantics: copying reference variables creates an alias
 * pointing to the exact same object on the heap, while the new keyword creates a distinct object.
 * 
 * Concepts: Reference variables, heap memory allocation, object aliasing, == operator.
 */
public class ExamHallTicketReferenceManagement {

    /**
     * Represents an exam hall ticket with candidate name and assigned seat number.
     */
    public static class HallTicket {
        String studentName;
        int seatNumber;

        /**
         * Constructor initializing candidate name and seat number.
         *
         * @param studentName Name of the examinee
         * @param seatNumber  Assigned examination seat number
         */
        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M4: Exam Hall Ticket Reference Management ===");

        // Create initial HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Assign a second variable pointing to that same object
        HallTicket copy = priya;

        // Mutate seat number via the second variable
        copy.seatNumber = 45;

        // Create a third, separate object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // Print observations
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
