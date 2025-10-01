import java.util.*;

public class sample {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}));
    }
}

class Solution {
    ArrayList<Integer> list;
    public void insert(int x) {
        int idx = lowerBound(x);
        list.add(idx, x);
    }

    // Lower bound: first index with element >= x
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


    public int getCount(int x){
        int idx = lowerBound(x);
        return list.size()-idx;
    }

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        list = new ArrayList<>();
        int[][] queue = new int[n][2];
        int k=0;
        Arrays.sort(people, (a, b)->(a[0]-b[0]));
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(people[j][0] != -1){
                    int cnt = getCount(people[j][0]);
                    if(cnt == people[j][1]){
                        queue[k][0] = people[j][0];
                        queue[k][1] = people[j][1];
                        k++;
                        insert(people[j][0]);
                        people[j][0]=-1;
                        break;
                    }
                }
            }
        }
        return queue;
    }
}