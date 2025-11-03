package practice;
import java.util.*;

public class sample{
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        dp = new int[e+1][n];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        int res = helper(e, 0, nums);
        if(res > 2*n){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
        sc.close();
    }

    public static int helper(int e, int i, int[] nums){
        if(e <= 0){
            return 0;
        }
        if(i == nums.length){
            return 2*nums.length+1;
        }
        if(dp[e][i] != -1)
            return dp[e][i]; 

        //do once time
        int once = helper(e-nums[i], i+1, nums)+1;
        //do twice
        int twice = helper(e-2*nums[i], i+1, nums)+2;
        //skip
        int skip = helper(e, i+1, nums);

        return dp[e][i] = Math.min(skip, Math.min(once, twice));
    }
}