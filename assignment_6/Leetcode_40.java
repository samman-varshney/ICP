package assignment_6;
import java.util.*;

public class Leetcode_40 {
    
}
class Solution {
    public void helper(int idx,int target,int[] candidates,List<List<Integer>> ans,List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || idx >= candidates.length || candidates[idx]>target)return;
        list.add(candidates[idx]);
        helper(idx+1,target-candidates[idx],candidates,ans,list);
        while(idx<candidates.length-1 && candidates[idx]==candidates[idx+1])
            idx++;
        list.remove(list.size()-1);
        helper(idx+1,target,candidates,ans,list);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(0,target,candidates,ans,list);
        return ans;
    }
}
