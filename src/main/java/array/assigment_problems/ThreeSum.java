package array.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem A3: 3Sum
 * Scenario: Budget Rebalancing Triplets
 * 
 * A budgeting tool needs to find every distinct combination of exactly three
 * transactions in an account history that cancel each other out to zero without
 * duplicate triplets.
 * 
 * Concepts: Sorting as setup, two-pointer inward scan, systematic duplicate
 * avoidance, O(n^2) time complexity.
 */
public class ThreeSum {

    /**
     * Finds all unique triplets that sum up to 0.
     *
     * @param nums Array of integers
     * @return 2D array of unique triplets summing to 0
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // Sort array first
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Early break: if the smallest remaining number is > 0, sum cannot be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A3: 3Sum ===");

        // Sample 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        int[][] res1 = threeSum(nums1);
        System.out.println("Output: " + Arrays.deepToString(res1));

        // Sample 2
        int[] nums2 = {0, 0, 0};
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        int[][] res2 = threeSum(nums2);
        System.out.println("Output: " + Arrays.deepToString(res2));

        // Additional Test Case
        int[] nums3 = {0, 1, 1};
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        int[][] res3 = threeSum(nums3);
        System.out.println("Output: " + Arrays.deepToString(res3));
    }
}
