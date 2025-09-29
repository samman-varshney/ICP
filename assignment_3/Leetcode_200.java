package assignment_3;

public class Leetcode_200 {
    class Solution {
    public void dfs(char[][] grid, int i, int j){
        int n = grid.length, m = grid[0].length;
        grid[i][j] = '0';

        if(j+1<m && grid[i][j+1] == '1')
            dfs(grid, i, j+1);
        if(j-1>=0 && grid[i][j-1] == '1')
            dfs(grid, i, j-1);
        if(i+1<n && grid[i+1][j] == '1')
            dfs(grid, i+1, j);
        if(i-1>=0 && grid[i-1][j] == '1')
            dfs(grid, i-1, j);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}
}
