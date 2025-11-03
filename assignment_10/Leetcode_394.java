package assignment_10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode_394 {


    public static void main(String[] args) {
        String s = "1+2*(2-3)/3+8";
        System.out.println(helper(s, 0, s.length()-1));
    }
    private static int precedence(char ch) {
    
    switch (ch) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
    }
    return -1;
}

    public static String helper(String str, int start, int end){
        char[] s = str.toCharArray();
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=start; i<=end; i++){
                if(s[i] == '('){ 
                    String temp = helper(str, i+1, end);
                    res.append(temp);
                    i += temp.length()+1;
                    
                }
                else if(s[i] == ')'){ 
                    while(!st.isEmpty()) res.append(st.pop());
                    return res.toString();
                }
                else if(Character.isDigit(s[i])) {
                    res.append(s[i]);
                }else{
                    while(!st.isEmpty() && precedence(s[i]) <= precedence(st.peek())){
                        res.append(st.pop());
                    }
                    st.push(s[i]);
                }
        }
        while(!st.isEmpty()) res.append(st.pop());
        return res.toString();
    }




    class Solution {
        public int helper(String str, int i, Queue<Character> sample) {
            while (i < str.length() && str.charAt(i) != ']') {

                int n = i;
                while (Character.isDigit(str.charAt(i))) {
                    i++;
                }
                if (i > n) {
                    int iter = Integer.parseInt(str.substring(n, i));
                    for (int j = 0; j < iter; j++)
                        n = helper(str, i + 1, sample);
                    i = n + 1;
                } else {
                    sample.add(str.charAt(i));
                    i++;
                }
            }
            return i;
        }

        public String decodeString(String str) {
            Queue<Character> sample = new LinkedList<>();
            for (int i = 0; i < str.length(); i++) {
                int n = i;
                while (Character.isDigit(str.charAt(i))) {
                    i++;
                }
                if (i > n) {
                    int iter = Integer.parseInt(str.substring(n, i));
                    for (int j = 0; j < iter; j++)
                        n = helper(str, i + 1, sample);
                    i = n;
                } else if (str.charAt(i) != ']')
                    sample.add(str.charAt(i));
            }
            StringBuilder ans = new StringBuilder();
            while (!sample.isEmpty())
                ans.append(sample.remove());
            return ans.toString();
        }
    }
}

//tc: O(n)
//sc: O(n)

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"