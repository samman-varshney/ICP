import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode_406 {
    class Solution {
        ArrayList<Integer> list;

        public void insert(int x) {
            int idx = lowerBound(x);
            list.add(idx, x);
        }

        public int lowerBound(int x) {
            int low = 0, high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid) < x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        public int getCount(int x) {
            int idx = lowerBound(x);
            return list.size() - idx;
        }

        public int[][] reconstructQueue(int[][] people) {
            int n = people.length;
            list = new ArrayList<>();
            int[][] queue = new int[n][2];
            Arrays.sort(people, (a, b) -> (a[0] - b[0]));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (people[j][0] != -1) {
                        int cnt = getCount(people[j][0]);
                        if (cnt == people[j][1]) {
                            queue[i][0] = people[j][0];
                            queue[i][1] = people[j][1];
                            insert(people[j][0]);
                            people[j][0] = -1;
                            break;
                        }
                    }
                }
            }
            return queue;
        }
    }
}


//tc: O(n^2logn)
//sc: O(n)


// Example 2:

// Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
// Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]