package array.class_problems;

import java.util.Arrays;

/**
 * Problem L3: Contains Duplicate
 * Scenario: Exam Seating Roll Number Verification
 * 
 * Before finalizing an exam seating chart, the office must double-check
 * that no roll number was accidentally entered twice in the list by
 * comparing every entry against every other entry using nested loops.
 * 
 * Concepts: Nested loops, pairwise comparison, boolean return logic, early exit.
 */
public class ContainsDuplicate {

    /**
     * Checks if any value appears at least twice in the array using nested loops.
     *
     * @param nums Array of integer roll numbers
     * @return true if duplicate exists, false if all elements are distinct
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem L3: Contains Duplicate ===");

        // Sample 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + containsDuplicate(nums1) + " (1 appears at positions 0 and 3)");

        // Sample 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + containsDuplicate(nums2) + " (Every value is distinct)");

        // Additional Test Case
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + containsDuplicate(nums3));
    }
}
