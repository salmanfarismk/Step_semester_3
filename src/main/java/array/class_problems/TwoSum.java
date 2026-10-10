package array.class_problems;

import java.util.Arrays;

/**
 * Problem L1: Two Sum
 * Scenario: Budget-Constrained Item Pairing
 * 
 * A shopkeeper wants to find two items from a list of prices that together
 * add up to exactly a customer's budget. Checking every possible pair using
 * two nested loops finds the two indices.
 * 
 * Concepts: Nested for loops, array indexing, basic pairwise search logic.
 */
public class TwoSum {

    /**
     * Finds the two indices of elements that sum up to target using nested loops.
     *
     * @param nums   The array of integer prices
     * @param target The target budget sum
     * @return An array containing the two indices [i, j]
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("=== Problem L1: Two Sum ===");

        // Sample 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1));

        // Sample 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2));

        // Additional Test Case
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
