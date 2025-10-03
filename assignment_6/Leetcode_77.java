package assignment_6;
import java.util.*;
public class Leetcode_77 {
    
}
class Solution {
    public void helper(int n, int k, List<Integer> temp, List<List<Integer>> list){
        if(k<=0){
            list.add(new ArrayList<>(temp));
            return ;
        }
        if(k>n)return ;
        temp.add(n);
        helper(n-1, k-1, temp, list);
        temp.remove(temp.size()-1);
        helper(n-1, k, temp, list);

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        helper(n, k, new ArrayList<>(), list);
        return list;
    }
}