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