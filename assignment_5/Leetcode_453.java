
import java.util.Arrays;

public class Leetcode_453 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

            int prev = intervals[0][1];
            int count = 0;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= prev) {
                    prev = intervals[i][1];

                } else {
                    count++;
                }
            }
            return count;
        }
    }
}


//tc: O(nlogn)
//sc: O(1)

// Example 1:

// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
// Example 2:

// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.