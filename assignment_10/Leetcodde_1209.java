package assignment_10;

import java.util.Stack;

public class Leetcodde_1209 {
    class Solution {

        public String removeDuplicates(String str, int k) {

            int n = str.length();
            char[] s = str.toCharArray();
            Stack<Integer> st = new Stack<>();
            int[] freq = new int[n];

            for (int i = 0; i < n; i++) {
                if (!st.isEmpty() && s[st.peek()] == s[i]) {
                    freq[i] = freq[st.peek()] + 1;
                    st.push(i);
                } else {
                    freq[i] = 1;
                    st.push(i);
                }

                if (!st.isEmpty() && freq[i] == k) {
                    for (int j = 0; j < k; j++) {
                        st.pop();
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            while (!st.isEmpty()) {
                res.append(s[st.pop()]);
            }
            return res.reverse().toString();
        }
    }
}

//tc: O(n)
//sc: O(n)

// Input: s = "abcd", k = 2
// Output: "abcd"
// Explanation: There's nothing to delete.
