package array.assigment_problems;

import java.util.Arrays;

/**
 * Problem A5: Find Minimum in Rotated Sorted Array
 * Scenario: Duty Roster Earliest Date Finder
 * 
 * A circular duty roster was originally sorted by join date, then rotated at
 * an unknown pivot. Find the original earliest join date (minimum element)
 * in O(log n) time using a modified binary search.
 * 
 * Concepts: Binary search adapted to a rotated array, comparing mid with right
 * boundary, handling unrotated arrays correctly in O(log n) time and O(1) space.
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array using binary search.
     *
     * @param nums Array of unique elements sorted ascending and rotated
     * @return The minimum element
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element, the inflection
            // point (and hence the minimum) must lie in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum is either at mid or to the left of mid.
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A5: Find Minimum in Rotated Sorted Array ===");

        // Sample 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + findMin(nums1));

        // Sample 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + findMin(nums2));

        // Sample 3 (No rotation)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + findMin(nums3) + " (No rotation actually occurred)");

        // Additional Test Case
        int[] nums4 = {2, 1};
        System.out.println("\nInput: nums = " + Arrays.toString(nums4));
        System.out.println("Output: " + findMin(nums4));
    }
}
