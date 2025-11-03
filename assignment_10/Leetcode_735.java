package assignment_10;

import java.util.Stack;

public class Leetcode_735 {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            int n = asteroids.length;
            while (i < n) {

                if (asteroids[i] < 0 && !stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() > Math.abs(asteroids[i]))
                        i++;
                    else if (stack.peek() < Math.abs(asteroids[i]))
                        stack.pop();
                    else {
                        stack.pop();
                        i++;
                    }
                } else {
                    stack.push(asteroids[i]);
                    i++;
                }

            }
            Stack<Integer> rev = new Stack<>();
            int len = 0;
            while (!stack.isEmpty()) {
                rev.push(stack.pop());
                len++;
            }
            i = 0;
            asteroids = new int[len];
            while (!rev.isEmpty()) {
                asteroids[i] = rev.pop();
                i++;
            }
            return asteroids;
        }
    }
}

// tc: O(n);
// sc: O(n)

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never
// collide.