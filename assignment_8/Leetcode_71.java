package assignment_8;
import java.util.*;
public class Leetcode_71 {
    
}

class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        
        Stack<String> st = new Stack<>();
        for(String s : arr){
            if(s.equals("") || s.equals("."))continue;
            if(s.equals("..")){
                if(!st.isEmpty())st.pop();
            }else{
                st.push(s);
            }
        }
        int k = st.size();
        String[] res = new String[k--];
        while(!st.isEmpty()){
            res[k--] = st.pop();
        }

        return "/"+String.join("/", res);
    }
}



//tc: O(n)
//sc: O(n)





// Example 1:

// Input: path = "/home/"

// Output: "/home"

// Explanation:

// The trailing slash should be removed.

// Example 2:

// Input: path = "/home//foo/"

// Output: "/home/foo"

// Explanation:

// Multiple consecutive slashes are replaced by a single one.