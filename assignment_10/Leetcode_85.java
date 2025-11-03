package assignment_10;

import java.util.Stack;

public class Leetcode_85 {
    class Solution {
        public int maximalRectangle(char[][] mat) {
            int n = mat[0].length, m = mat.length;
            int heights[] = new int[n];
            int lg = Integer.MIN_VALUE;
            Histogram h = new Histogram();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != '0')
                        heights[j]++;
                    else
                        heights[j] = 0;
                }

                lg = Math.max(lg, h.LG(heights));
            }
            return lg;
        }
    }

    class Histogram {

        public int LG(int[] arr) {
            Stack<Integer> st = new Stack<>();
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                    int h = arr[st.pop()];
                    int r = i;
                    if (st.isEmpty()) {
                        ans = Math.max(h * r, ans);
                    } else {
                        int l = st.peek();
                        int area = h * (r - l - 1);
                        ans = Math.max(area, ans);
                    }
                }
                st.push(i);
            }
            int r = arr.length;
            while (!st.isEmpty()) {
                int h = arr[st.pop()];
                if (st.isEmpty()) {
                    ans = Math.max(h * r, ans);
                } else {
                    int l = st.peek();
                    int area = h * (r - l - 1);
                    ans = Math.max(area, ans);
                }
            }

            return ans;
        }
    }
}

// tc: O(n^2)
// sc: O(n)

// Input: matrix =
// [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.