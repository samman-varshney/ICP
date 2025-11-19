package assignment_13;
import java.util.*;
public class Leetcode_871 {
    
}
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stn) {
        int n = stn.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b-a));
        int i=0, stops = 0;
        while(startFuel < target){

            while(i<n && startFuel>=stn[i][0]){
                pq.add(stn[i][1]);
                i++;
            }

            if(pq.isEmpty())
                return -1;
           
            startFuel += pq.poll();
            stops++;
        }
        return stops;
    }
}


//ts : O(n)
//sc : O(n)

// Example 1:

// Input: target = 1, startFuel = 1, stations = []
// Output: 0
// Explanation: We can reach the target without refueling.
