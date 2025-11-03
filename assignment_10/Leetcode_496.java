package assignment_10;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode_496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums2.length;
            Stack<Integer> st = new Stack<>();
            st.push(-1);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = n - 1; i >= 0; i--) {
                while (st.peek() <= nums2[i] && st.peek() != -1)
                    st.pop();
                map.put(nums2[i], st.peek());
                st.push(nums2[i]);
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}

// tc: O(n);
// sc: (n)

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
// the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
// the answer is -1.