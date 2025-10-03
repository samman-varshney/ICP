package assignment_6;
public class Leetcode_79 {
    
}

class Solution {
    public boolean dfs(char[][] b, String s, int i, int j, int k){
        if(k == s.length())return true;

        if(i<0 || i>=b.length || j<0 || j>=b[0].length || b[i][j] != s.charAt(k))
        return false;
        char c =  b[i][j];
        b[i][j] = '#';

        boolean result = dfs(b,s,i-1,j,k+1)||dfs(b,s,i,j-1,k+1)||dfs(b,s,i,j+1,k+1)||dfs(b,s,i+1,j,k+1);
        b[i][j] =  c;
        return result;

}
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0))return true;
            }
        }
        return false;
    }
}