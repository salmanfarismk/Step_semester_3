package array.class_problems;

import java.util.Arrays;

/**
 * Problem L5: Rotate Array
 * Scenario: Music Playlist Queue Rotation
 * 
 * A playlist needs to be shifted so the last few songs move to the front
 * of the queue, rotating the whole list to the right by k positions using
 * modulo arithmetic and building the new order.
 * 
 * Concepts: Modulo arithmetic for wraparound indexing, building a new array
 * from calculated positions, array copying.
 */
public class RotateArray {

    /**
     * Rotates an integer array to the right by k positions.
     *
     * @param nums The array to rotate
     * @param k    The number of positions to rotate to the right
     * @return The rotated array (also updates nums in place)
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;
        // Normalize k to avoid unnecessary full cycles and handle negative k
        k = k % n;
        if (k < 0) {
            k += n;
        }

        if (k == 0) {
            return nums;
        }

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        // Copy values back into nums
        System.arraycopy(newArray, 0, nums, 0, n);

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem L5: Rotate Array ===");

        // Sample 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        int[] result1 = rotateArray(nums1, k1);
        System.out.println("Output: " + Arrays.toString(result1));

        // Sample 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        int[] result2 = rotateArray(nums2, k2);
        System.out.println("Output: " + Arrays.toString(result2) + " (k % 2 = 1, single rotation)");

        // Additional Test Case
        int[] nums3 = {-1, -100, 3, 99};
        int k3 = 2;
        System.out.println("\nInput: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        int[] result3 = rotateArray(nums3, k3);
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
