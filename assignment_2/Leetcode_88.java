package assignment_2;

public class Leetcode_88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] dummy = new int[m];
            for (int i = 0; i < m; i++)
                dummy[i] = nums1[i];

            int i = 0, j = 0;
            int k = 0;
            while (i < m && j < n) {
                if (dummy[i] < nums2[j]) {
                    nums1[k] = dummy[i++];
                } else {
                    nums1[k] = nums2[j++];
                }
                k++;
            }
            while (i < m) {
                nums1[k++] = dummy[i++];
            }
            while (j < n) {
                nums1[k++] = nums2[j++];
            }
        }
    }
}

// tc: O(n+m)
// sc = O(m)

// Example 1:

// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
// from nums1.
// Example 2:

// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].
