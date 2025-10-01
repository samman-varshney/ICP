package assignment_4;

public class Leetcode_567 {
    class Solution {

        public boolean helper(int[] f1, int[] f2) {
            for (int i = 0; i < 26; i++) {
                if (f1[i] != f2[i])
                    return false;
            }
            return true;
        }

        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            if (n > m)
                return false;

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (int i = 0; i < n; i++) {
                freq1[s1.charAt(i) - 'a'] += 1;
                freq2[s2.charAt(i) - 'a'] += 1;
            }

            if (helper(freq1, freq2))
                return true;

            for (int i = n; i < m; i++) {
                freq2[s2.charAt(i - n) - 'a'] -= 1;
                freq2[s2.charAt(i) - 'a'] += 1;
                if (helper(freq1, freq2))
                    return true;
            }
            return false;
        }
    }
}

//tc: O(26*m)
//sc: O(2*n)

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
 