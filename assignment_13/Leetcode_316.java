package assignment_13;
import java.util.*;
public class Leetcode_316 {
    
}
class Solution {
    public String removeDuplicateLetters(String s) {
    if(s.equals(""))
        return "";
    Stack<Character> sample = new Stack<>();
    boolean isvisited[] = new boolean[26];
    int[] lastidx = new int[26];
    for(int i =0;i<s.length();i++){
        lastidx[s.charAt(i)-'a']=i;
    }
    for(int i = 0;i<s.length();i++){
        char curr = s.charAt(i);
        if(!isvisited[curr-'a']){
            while(!sample.isEmpty() && sample.peek()>curr && lastidx[sample.peek()-'a']>i)
                
                    isvisited[sample.pop()-'a'] = false;
            sample.push(curr);
            isvisited[curr-'a']=true;
        }
    }
    Stack<Character> rev = new Stack<>();
    while(!sample.isEmpty())
        rev.push(sample.pop());
    StringBuilder str = new StringBuilder();
    while(!rev.isEmpty())
        str.append(rev.pop());
    return str.toString();
    }
}


//tc : O(n)
//sc : O(n)


// Example 1:

// Input: s = "bcabc"
// Output: "abc"
// Example 2:

// Input: s = "cbacdcbc"
// Output: "acdb"