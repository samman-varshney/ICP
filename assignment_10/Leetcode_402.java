package assignment_10;

import java.util.Stack;

public class Leetcode_402 {
    class Solution {
        public String removeKdigits(String num, int k) {
            if (k == num.length())
                return "0";
            Stack<Character> s = new Stack<>();
            int i = 0;
            while (i < num.length()) {
                char curr = num.charAt(i);
                while (!s.isEmpty() && s.peek() > curr && k > 0) {
                    k--;
                    s.pop();
                }
                s.push(curr);
                i++;
            }

            while (k-- > 0)
                s.pop();

            Stack<Character> rev = new Stack<>();
            while (!s.isEmpty())
                rev.push(s.pop());
            StringBuilder answer = new StringBuilder();
            while (rev.size() != 1 && !rev.isEmpty() && rev.peek() == '0')
                rev.pop();
            while (!rev.isEmpty())
                answer.append(rev.pop());
            return answer.toString();
        }
    }
}


//tc: O(n)
//sc: O(n)

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.