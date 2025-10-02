import java.util.*;

public class sample {
    public static void main(String[] args) {
        
    }
}

class MedianFinder {
    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;
    public MedianFinder() {
        leftHalf = new PriorityQueue<>((a, b)->(b-a));
        rightHalf = new PriorityQueue<>((a, b)->(a-b));
    }
    
    public void addNum(int num) {
        if(num < )
    }
    
    public double findMedian() {
        return 1.0;
    }
}