package assignment_8;
import java.util.*;
public class Leetcode_150 {
    
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op2+op1;
                st.push(res);
            }else if(s.equals("-")){
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op2-op1;
                st.push(res);
            }else if(s.equals("*")){
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op2*op1;
                st.push(res);
            }else if(s.equals("/")){
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op2/op1;
                st.push(res);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}

//tc: O(n)
//sc: O(n)




// Example 1:

// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
// Example 2:

// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6
