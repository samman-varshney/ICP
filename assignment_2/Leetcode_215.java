package assignment_2;

public class Leetcode_215 {

    class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] dp = new int[2*10000+1];

        for(int num: nums){
            dp[num+10000] += 1;
        }
        int i=dp.length-1;
        while(i>=0){
            if(dp[i] != 0){
                k -= dp[i];
                if(k <= 0)
                    return i-10000;
            }
            i--;
        }
        return -1;
    }
}
}
