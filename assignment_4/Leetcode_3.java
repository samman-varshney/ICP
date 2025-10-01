package assignment_4;

public class Leetcode_3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if (n == 0 || n == 1)
                return n;
            boolean freq[] = new boolean[127];
            int i = 0, max = Integer.MIN_VALUE, start = -1;
            while (i < n) {
                char ch = s.charAt(i);
                if (!freq[ch]) {
                    freq[ch] = true;

                    int len = i - start;
                    max = max < len ? len : max;
                } else {
                    start++;
                    while (s.charAt(start) != ch) {
                        freq[s.charAt(start++)] = false;
                    }

                }
                i++;
            }
            return max;
        }
    }
}
//tc : O(n)
//sc : O(n)

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.