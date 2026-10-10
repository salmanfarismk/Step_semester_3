package arrays_and_methods.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Placement Drive Shortlisting & Ranking Engine
 * Scenario: Campus Placement Eligibility & Composite Ranking
 * 
 * Filters candidates using overloaded eligibility methods and ranks shortlisted
 * candidates by composite score in descending order using Arrays.sort() and Comparable.
 * 
 * Concepts: Method overloading, static methods, Comparable interface,
 * Arrays.sort(), encapsulation, composite scoring.
 */
public class PlacementDriveRankingEngine {

    /**
     * Represents a job applicant with academic and coding test credentials.
     */
    public static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        /**
         * Computes the composite score: (cgpa * 10) + (codingScore * 0.5).
         *
         * @return The composite ranking score
         */
        public double getCompositeScore() {
            return (cgpa * 10.0) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {
            // Sort in descending order of composite score
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }

        @Override
        public String toString() {
            return String.format("%s (%.1f)", name, getCompositeScore());
        }
    }

    /**
     * Overloaded eligibility check: CGPA-only filter for high achievers.
     *
     * @param cgpa Student's CGPA
     * @return true if CGPA meets the direct threshold (>= 7.5)
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Overloaded eligibility check: combined CGPA and coding score filter for borderline cases.
     *
     * @param cgpa        Student's CGPA
     * @param codingScore Student's coding test score
     * @return true if eligible directly or through borderline criteria
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }

    /**
     * Filters eligible candidates, sorts them using Arrays.sort(), and formats the ranking string.
     *
     * @param candidates Array of applicants
     * @return Formatted ranking string of shortlisted candidates
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> eligibleList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c != null && isEligible(c.getCgpa(), c.getCodingScore())) {
                eligibleList.add(c);
            }
        }

        Candidate[] shortlisted = eligibleList.toArray(new Candidate[0]);
        // Rank solely using the standard library's Arrays.sort and Comparable implementation
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(shortlisted[i].toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Placement Drive Shortlisting & Ranking Engine ===");

        Candidate[] batch1 = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println("Output: " + shortlistAndRank(batch1));
    }
}
