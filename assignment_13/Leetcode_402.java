package assignment_13;
import java.util.*;
public class Leetcode_402 {
    
}
class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length())return "0";
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<num.length()){
            char curr = num.charAt(i);
            while(!s.isEmpty() && s.peek()>curr && k>0)
            {   k--;
                s.pop();
            }
            s.push(curr);
            i++;
        }
    

    
    while(k-->0)
        s.pop();
    
    StringBuilder res = new StringBuilder();
    while(!s.isEmpty()){
        res.append(s.pop());
    }
    res.reverse();
    i=0;
    while(i<res.length() && res.charAt(i) == '0'){
        i++;
    }
    String data = res.toString().substring(i);
    return data.length()==0?"0":data;
    }
}


//tc : O(n)
//Sc : O(n)


// Example 1:

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

// Example 2:

// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

// Example 3:

// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.