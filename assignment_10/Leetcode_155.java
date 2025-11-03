package assigment_10;

import java.util.*;

public class Leetcode_155 {
    class MinStack {
        Stack<Integer> st;
        PriorityQueue<Integer> min;
        Map<Integer, Integer> deleteMap;

        public MinStack() {
            st = new Stack<>();
            min = new PriorityQueue<>();
            deleteMap = new HashMap<>();
        }

        public void push(int val) {
            st.push(val);
            min.offer(val);
        }

        public void pop() {
            int val = st.pop();
            deleteMap.put(val, deleteMap.getOrDefault(val, 0) + 1);
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            cleanMinHeap();
            return min.peek();
        }

        private void cleanMinHeap() {
            while (!min.isEmpty() && deleteMap.getOrDefault(min.peek(), 0) > 0) {
                int val = min.poll();
                deleteMap.put(val, deleteMap.get(val) - 1);
                if (deleteMap.get(val) == 0) {
                    deleteMap.remove(val);
                }
            }
        }
    }
}


//tc: O(1)ForPush,Pop,Top,O(N)ForGetminInWorstCase,AmortizedO(1)InAverageCase
//sc: O(n);

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2