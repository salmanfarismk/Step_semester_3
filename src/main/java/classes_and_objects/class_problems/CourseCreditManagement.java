package classes_and_objects.class_problems;

/**
 * Problem M3: Course Credit Management
 * Scenario: Academic Course Curriculum Configuration
 * 
 * Demonstrates constructor overloading and constructor chaining using this(...)
 * to support both theory-only courses and theory-with-lab courses without duplicating setup logic.
 * 
 * Concepts: Constructor overloading, constructor chaining with this(...), clean code reuse.
 */
public class CourseCreditManagement {

    /**
     * Represents an academic course with credits and optional lab credits.
     */
    public static class Course {
        private final String code;
        private final String title;
        private final int credits;
        private final int labCredits;

        /**
         * Primary constructor setting all four fields directly.
         *
         * @param code       Course code (e.g., 21CSC205L)
         * @param title      Course title
         * @param credits    Theory lecture credits
         * @param labCredits Practical laboratory credits
         */
        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        /**
         * Secondary constructor for theory-only courses.
         * Chains to the 4-parameter constructor via this(...) setting labCredits to 0.
         *
         * @param code    Course code (e.g., 21CSC201J)
         * @param title   Course title
         * @param credits Theory lecture credits
         */
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        /**
         * Computes the total course credits.
         *
         * @return Sum of lecture credits and laboratory credits
         */
        public int totalCredits() {
            return credits + labCredits;
        }

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem M3: Course Credit Management ===");

        // Theory-only course (chains via this(...))
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        System.out.println(theoryCourse.getCode() + " total credits: " + theoryCourse.totalCredits());

        // Course with separate lab component
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);
        System.out.println(labCourse.getCode() + " total credits: " + labCourse.totalCredits());
    }
}
