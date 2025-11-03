package assignment_10;

import java.util.Arrays;

public class Leetcode_853 {
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            int[][] nums = new int[n][2];

            for (int i = 0; i < n; i++) {
                nums[i][0] = position[i];
                nums[i][1] = speed[i];
            }

            Arrays.sort(nums, (a, b) -> (a[0] - b[0]));

            int count = 0;
            float time = 0;
            for (int i = n - 1; i >= 0; i--) {
                float temp = (target - nums[i][0]) / (nums[i][1] * 1.0f);
                if (temp > time) {
                    count++;
                    time = temp;
                }
            }

            return count;
        }
    }
}

// tc: O(nlogn)
// sc: O(n)

// Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

// Output: 3

// Explanation:

// The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting
// each other at 12. The fleet forms at target.
// The car starting at 0 (speed 1) does not catch up to any other car, so it is
// a fleet by itself.
// The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each
// other at 6. The fleet moves at speed 1 until it reaches target.