package assignment_3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_54 {
    class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n= matrix.length,m=matrix[0].length;
        int minc = 0,minr =0,maxc = matrix[0].length-1,maxr = matrix.length-1,count=0;
        while(count<m*n){
            for(int i=minc;i<=maxc&&count<m*n;i++,count++)
                result.add(matrix[minr][i]);
            minr++;
            for(int i=minr;i<=maxr &&count<m*n;i++,count++)
                result.add(matrix[i][maxc]);
            maxc--;
            for(int i=maxc;i>=minc &&count<m*n;i--,count++)
                result.add(matrix[maxr][i]);
            maxr--;
            for(int i=maxr;i>=minr &&count<m*n;i--,count++)
                result.add(matrix[i][minc]);
            minc++;
       }
       return result;

    } 
}
}
