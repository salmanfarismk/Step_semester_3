package classes_and_objects.class_problems;

/**
 * Problem M4: Library ID Card Management
 * Scenario: Reference Aliasing vs Object Identity
 * 
 * Demonstrates that object reference assignment shares the exact same underlying heap object,
 * whereas creating a new object with identical fields yields a completely separate instance.
 * 
 * Concepts: Reference variables, heap memory, shallow aliasing vs independent instances, == operator.
 */
public class LibraryIdCardManagement {

    /**
     * Represents a student's library identity card.
     */
    public static class IdCard {
        String name;
        int booksIssued;

        /**
         * Constructor initializing cardholder name and initial books issued count.
         *
         * @param name        Cardholder name
         * @param booksIssued Initial number of books borrowed
         */
        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M4: Library ID Card Management ===");

        // Create initial object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // Assign second variable pointing to the same reference
        IdCard duplicate = ravi;

        // Mutate through second variable
        duplicate.booksIssued = 3;

        // Create third, separate object with identical field values
        IdCard separate = new IdCard("Ravi", 3);

        // Print observations
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
