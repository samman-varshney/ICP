package assignment_7;
import java.util.*;
public class Leetcode_62 {
    
}
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for(int i=n-2; i>=0; i--){
            int[] temp = new int[m];
            for(int j=m-1; j>=0; j--){
                //right
                int right = 0;
                if(i+1 < n){
                    right = dp[j];
                }
                //down
                int down = 0;
                if(j+1 < m){
                    down = temp[j+1];
                }
                temp[j] = right + down;
            }
            dp = temp;
        }
        return dp[0];
    }
}


//tc: O(nm)
//sc: O(1)

// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down