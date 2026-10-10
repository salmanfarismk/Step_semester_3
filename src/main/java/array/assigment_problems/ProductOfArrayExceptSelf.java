package array.assigment_problems;

import java.util.Arrays;

/**
 * Problem A1: Product of Array Except Self
 * Scenario: Bundle Pricing Engine
 * 
 * A pricing engine needs, for every product in a bundle, the combined price
 * of every OTHER product in that same bundle — computed without ever dividing
 * by the current product's own price (which could be zero).
 * 
 * Concepts: Prefix and suffix products, two-pass array traversal, handling zero
 * values without division, O(n) time with O(1) extra space (beyond the output array).
 */
public class ProductOfArrayExceptSelf {

    /**
     * Computes the product of all elements except self for each element in nums,
     * without using division.
     *
     * @param nums Array of integer prices
     * @return Array where answer[i] is the product of all elements except nums[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: answer[i] stores the product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Multiply in the running product of all elements to the right of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A1: Product of Array Except Self ===");

        // Sample 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        // Sample 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));

        // Additional Test Case
        int[] nums3 = {0, 0};
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums3)));
    }
}
