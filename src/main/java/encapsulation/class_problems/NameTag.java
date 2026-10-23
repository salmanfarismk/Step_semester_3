package encapsulation.class_problems;

/**
 * Problem 3: The Nickname Tag
 * Scenario: Chat App Friendly Nickname Formatter
 * 
 * Demonstrates immutability by creating an immutable NameTag class that parses
 * a full name once inside the constructor, stores the resulting components as
 * final fields, and offers no mutators.
 * 
 * Concepts: Immutability, final fields, constructor preprocessing, defensive design.
 */
public class NameTag {

    private final String firstName;
    private final String lastName;
    private final String nickname;

    /**
     * Initializes the NameTag by splitting the full name once into first and last names,
     * precomputing the immutable nickname.
     *
     * @param fullName Full name containing exactly one first and one last name separated by a space
     */
    public NameTag(String fullName) {
        if (fullName == null || !fullName.trim().contains(" ")) {
            throw new IllegalArgumentException("Full name must contain both first and last name separated by a space.");
        }

        String[] parts = fullName.trim().split("\\s+");
        this.firstName = parts[0];
        this.lastName = parts[1];
        this.nickname = this.firstName + " " + this.lastName.charAt(0) + ".";
    }

    /**
     * Returns the formatted nickname (first name + last name initial).
     *
     * @return Formatted nickname (e.g., "Maria G.")
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Returns the first name.
     *
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name.
     *
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Nickname Tag ===");

        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());

        NameTag tag2 = new NameTag("John Doe");
        System.out.println("tag2.getNickname() -> " + tag2.getNickname());
    }
}
