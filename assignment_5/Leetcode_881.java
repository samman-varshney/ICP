
public class Leetcode_881 {
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            int n = people.length;
            int[] nums = new int[30001];
            for (int x : people) {
                nums[x] += 1;
            }
            int boats = 0;
            int i = 0, j = 30000;
            while (i <= j) {
                while (i <= j && nums[i] == 0)
                    i++;
                while (i <= j && nums[j] == 0)
                    j--;

                if (i < j && i + j <= limit) {
                    int freq = Math.min(nums[i], nums[j]);
                    boats += freq;
                    nums[i] -= freq;
                    nums[j] -= freq;
                } else if (i == j && i <= limit) {
                    if (i <= limit / 2) {
                        boats += (nums[i] + 1) / 2;
                    } else {
                        boats += nums[i];
                    }
                    nums[i] = 0;
                    i++;
                    j--;
                } else if (i <= j) {
                    boats += nums[j];
                    nums[j] = 0;
                    j--;
                }
            }
            return boats;
        }
    }
}

//tc: O(30000);
//sc: O(30000);



// Example 1:

// Input: people = [1,2], limit = 3
// Output: 1
// Explanation: 1 boat (1, 2)

// Example 2:

// Input: people = [3,2,2,1], limit = 3
// Output: 3
// Explanation: 3 boats (1, 2), (2) and (3)

// Example 3:

// Input: people = [3,5,3,4], limit = 5
// Output: 4
// Explanation: 4 boats (3), (3), (4), (5)
 
