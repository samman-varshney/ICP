package assignment_7;
import java.util.*;
public class Leetcode_198 {
    
}
class Solution {
    int n;
    int[] nums;
    int[] dp;
    public int helper(int i){
        if( i >= n ){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        //pick
        int pick = helper(i+2) + nums[i];
        //non pick
        int nonPick = helper(i+1);


        return dp[i] = Math.max(pick , nonPick);
    }
    public int rob(int[] arr) {
        n = arr.length;
        nums = arr;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0);
    }
}


//tc: O(n)
//sc: O(n)

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.