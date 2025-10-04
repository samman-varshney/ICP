package assignment_7;

public class Leetcode_53 {
    
}
class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum =Integer.MIN_VALUE;
        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            if(maxsum<sum)
                maxsum = sum;
            if(sum<=0)
                sum=0;
           
       } 
       return maxsum;
    }
}