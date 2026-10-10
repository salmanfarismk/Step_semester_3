package array.assigment_problems;

import java.util.Arrays;

/**
 * Problem A2: Maximum Subarray
 * Scenario: Best Contiguous Trading Stretch
 * 
 * A trader has a full year of daily profit-or-loss figures and wants to find
 * the single best contiguous stretch of days with the highest combined total
 * using Kadane's algorithm.
 * 
 * Concepts: Kadane's algorithm, the "extend vs. restart" decision, running-sum
 * reset logic, handling all-negative arrays correctly in O(n) time and O(1) space.
 */
public class MaximumSubarray {

    /**
     * Finds the contiguous subarray with the largest sum using Kadane's algorithm.
     *
     * @param nums Array of daily profit/loss figures
     * @return The maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current running subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track the highest sum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A2: Maximum Subarray ===");

        // Sample 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + maxSubArray(nums1) + " (Subarray [4, -1, 2, 1] sums to 6)");

        // Sample 2
        int[] nums2 = {-3, -1, -2};
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + maxSubArray(nums2) + " (All negative: single largest value is -1)");

        // Additional Test Case
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + maxSubArray(nums3));
    }
}
