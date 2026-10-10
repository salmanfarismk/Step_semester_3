package classes_and_objects.assigment_problems;

/**
 * Problem M1: Library Inventory Management
 * Scenario: Library Book Stock Tracking
 * 
 * Replaces parallel arrays with an object-oriented BookInventory structure
 * encapsulating book title, author, and available copies into a cohesive record.
 * 
 * Concepts: Class definition, parameterized constructors, instance methods, array of objects.
 */
public class LibraryInventoryManagement {

    /**
     * Represents a book record in the library collection.
     */
    public static class BookInventory {
        private final String title;
        private final String author;
        private final int copiesAvailable;

        /**
         * Constructor that initializes all three book inventory fields.
         *
         * @param title           Title of the book
         * @param author          Author of the book
         * @param copiesAvailable Current number of copies in stock
         */
        public BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        /**
         * Prints the formatted book catalog entry.
         */
        public void printEntry() {
            System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M1: Library Inventory Management ===");

        // Create four BookInventory objects
        BookInventory[] inventory = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        // Print each entry in a loop
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
