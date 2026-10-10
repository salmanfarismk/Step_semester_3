package array.class_problems;

import java.util.Arrays;

/**
 * Problem L4: Merge Two Sorted Arrays
 * Scenario: Examination Score Consolidation
 * 
 * Two class sections each submit their exam scores already sorted from
 * lowest to highest. The examination office needs one single combined sorted
 * list without re-sorting everything from scratch using a two-pointer approach.
 * 
 * Concepts: Two-index (two-pointer) array traversal, while loops, comparing and
 * copying elements, handling a fully-consumed array.
 */
public class MergeTwoSortedArrays {

    /**
     * Merges two sorted integer arrays into a single sorted array.
     *
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return Fully merged, sorted result array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return new int[]{};
        }
        if (arr1 == null || arr1.length == 0) {
            return arr2 == null ? new int[]{} : Arrays.copyOf(arr2, arr2.length);
        }
        if (arr2 == null || arr2.length == 0) {
            return Arrays.copyOf(arr1, arr1.length);
        }

        int[] result = new int[arr1.length + arr2.length];
        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result

        // Compare elements and copy the smaller one
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1 if any
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2 if any
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem L4: Merge Two Sorted Arrays ===");

        // Sample 1
        int[] arr1_1 = {1, 3, 5};
        int[] arr2_1 = {2, 4, 6};
        int[] merged1 = mergeSortedArrays(arr1_1, arr2_1);
        System.out.println("arr1 = " + Arrays.toString(arr1_1) + ", arr2 = " + Arrays.toString(arr2_1));
        System.out.println("Output: " + Arrays.toString(merged1));

        // Sample 2
        int[] arr1_2 = {};
        int[] arr2_2 = {1, 2, 3};
        int[] merged2 = mergeSortedArrays(arr1_2, arr2_2);
        System.out.println("\narr1 = " + Arrays.toString(arr1_2) + ", arr2 = " + Arrays.toString(arr2_2));
        System.out.println("Output: " + Arrays.toString(merged2));

        // Additional Test Case
        int[] arr1_3 = {4, 7, 9};
        int[] arr2_3 = {1, 2, 3, 5, 8, 10};
        int[] merged3 = mergeSortedArrays(arr1_3, arr2_3);
        System.out.println("\narr1 = " + Arrays.toString(arr1_3) + ", arr2 = " + Arrays.toString(arr2_3));
        System.out.println("Output: " + Arrays.toString(merged3));
    }
}
