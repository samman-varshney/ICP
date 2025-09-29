package assignment_3;

public class Leetcode_74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;

            int i = 0, j = m - 1;
            while (j >= 0 && i < n) {
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
}
