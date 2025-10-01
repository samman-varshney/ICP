package assignment_4;

public class Leetcode_424 {
    class Solution {
        public boolean helper(int[] f, int k) {
            int max = Integer.MIN_VALUE;
            int total = 0;
            for (int x : f) {
                max = Math.max(max, x);
                total += x;
            }
            return total - max <= k;
        }

        public int characterReplacement(String s, int k) {
            int n = s.length();
            int[] freq = new int[26];
            int j = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                freq[s.charAt(i) - 'A'] += 1;
                while (j < i && !helper(freq, k)) {
                    freq[s.charAt(j) - 'A'] -= 1;
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}

//tc: O(n);
//sc: O(n);

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
 