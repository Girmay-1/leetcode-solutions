package algorithms_and_data_structures.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

    }
   //offer and poll are log(n), peek is O(1). So this method is O(logn).
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        //balance
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

    }
    //O(1).
    public double findMedian() {
        return (maxHeap.size() == minHeap.size())? (maxHeap.peek() + minHeap.peek())/ 2.0: maxHeap.peek();

    }
    //space : O(n). due to the heaps.
}
