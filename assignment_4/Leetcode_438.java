package assignment_4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_438 {
    class Solution {

        public boolean helper(int[] f1, int[] f2) {
            for (int i = 0; i < 26; i++) {
                if (f1[i] != f2[i])
                    return false;
            }
            return true;
        }

        public List<Integer> checkInclusion(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            List<Integer> res = new ArrayList<>();
            if (n > m)
                return res;

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (int i = 0; i < n; i++) {
                freq1[s1.charAt(i) - 'a'] += 1;
                freq2[s2.charAt(i) - 'a'] += 1;
            }

            if (helper(freq1, freq2))
                res.add(0);

            for (int i = n; i < m; i++) {
                freq2[s2.charAt(i - n) - 'a'] -= 1;
                freq2[s2.charAt(i) - 'a'] += 1;
                if (helper(freq1, freq2))
                    res.add(i - n + 1);
            }
            return res;
        }

        public List<Integer> findAnagrams(String s, String p) {
            return checkInclusion(p, s);
        }
    }
}


//tc: O(26*n)
//sc: O(1)


// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
 