package array.assigment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem A4: Subarray Sum Equals K
 * Scenario: Hostel Attendance Net-Change Auditor
 * 
 * A hostel warden reviewing daily attendance changes wants to know how many
 * contiguous stretches of days had a net change of exactly k using running
 * prefix sums and a hash map.
 * 
 * Concepts: Running prefix sums, hash map frequency counting, base case
 * initialization (empty prefix), O(n) time and O(n) space.
 */
public class SubarraySumEqualsK {

    /**
     * Counts the total number of continuous subarrays whose sum equals k.
     *
     * @param nums Array of integers (can contain negative values)
     * @param k    Target sum
     * @return Number of contiguous subarrays summing to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        // Base case: prefix sum of 0 occurs once before traversing the array
        prefixSumFreq.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in prefix map, add its frequency
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }

            // Record current prefix sum into map
            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A4: Subarray Sum Equals K ===");

        // Sample 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + subarraySum(nums1, k1) + " (Subarrays [1, 1] at 0-1 and 1-2)");

        // Sample 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + subarraySum(nums2, k2) + " (Subarrays [1, -1], [0], [1, -1, 0])");

        // Additional Test Case
        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        System.out.println("\nInput: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Output: " + subarraySum(nums3, k3));
    }
}
