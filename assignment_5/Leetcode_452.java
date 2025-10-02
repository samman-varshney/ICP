
import java.util.Arrays;

public class Leetcode_452 {
    class Solution {
        public int findMinArrowShots(int[][] segments) {
            Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));
            int ans = 0, arrow = 0;
            for (int i = 0; i < segments.length; i++) {
                if (ans == 0 || segments[i][0] > arrow) {
                    ans++;
                    arrow = segments[i][1];
                }
            }
            return ans;
        }
    }
}


//tc: O(nlogn)
//sc: O(1)

// Example 1:

// Input: points = [[10,16],[2,8],[1,6],[7,12]]
// Output: 2
// Explanation: The balloons can be burst by 2 arrows:
// - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
// - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
// Example 2:

// Input: points = [[1,2],[3,4],[5,6],[7,8]]
// Output: 4
// Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
