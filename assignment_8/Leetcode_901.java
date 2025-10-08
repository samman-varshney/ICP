package assignment_8;
import java.util.*;
public class Leetcode_901 {
    
}

class StockSpanner {
    Stack<int[]> st ;
    int count ;
    public StockSpanner() {
        st = new Stack<>();
        count = -1;
    }
    
    public int next(int price) {
        count++;
    
        while(!st.isEmpty() && st.peek()[0] <= price)
            st.pop();
    
        int res = st.isEmpty()?count+1:count - st.peek()[1];
        st.push(new int[]{price, count});
        return res;
    }
}



//tc: O(n)
//sc: O(n)

// Example 1:

// Input
// ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
// [[], [100], [80], [60], [70], [60], [75], [85]]
// Output
// [null, 1, 1, 1, 2, 1, 4, 6]