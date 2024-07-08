package algorithms_and_data_structures.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FindMedianWindow {
    // Initialize two heaps: miniHeap and maxHeap
    // miniHeap stores the larger half of the numbers
    // maxHeap stores the smaller half of the numbers
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> miniHeap = new PriorityQueue<>();

    // Map to track elements removed from the heaps but still present in the sliding window
    private Map<Integer, Integer> delayed = new HashMap<>();

    // Size of miniHeap and maxHeap
    private int miniHeapSize;
    private int maxHeapSize;

    // Size of the sliding window
    private int k;

    // Constructor to initialize the sliding window size
    public FindMedianWindow(int k) {
        this.k = k;
    }

    // Method to add a number to the heaps
    public void addNum(int num) {
        System.out.println("adding number:" + num);
        // Determine which heap to add the number to based on its value
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            System.out.println("num belongs to the maxHeap");
            maxHeap.offer(num);
            ++miniHeapSize;
            System.out.println("maxHeap size increased to : " + miniHeapSize);
        } else {
            System.out.println("num belongs to the mean heap");
            miniHeap.offer(num);
            ++maxHeapSize;
            System.out.println("minHeap size increased to : " + maxHeapSize);
        }
        // Rebalance the heaps if necessary

        rebalance();
    }

    // Method to find the median of the current sliding window
    public double findMedian() {

        // If k is odd, return the root of the miniHeap (larger half)
        // If k is even, return the average of the roots of both heaps
        double median =  (k & 1) == 1 ? maxHeap.peek() : ((double) maxHeap.peek() + miniHeap.peek()) / 2;
        System.out.println("median so far :" + median);
        return median;
    }

    // Method to remove a number from the window.
    public void removeNum(int num) {
        System.out.println("removing :" + num + " from the window");
        // Increment the count of the number in the delayed map
        delayed.merge(num, 1, Integer::sum);
        System.out.println("added " + num + " to the map");
        // Determine which heap the number belongs to and update its size
        if (num <= maxHeap.peek()) {
            --miniHeapSize;
            System.out.println( num +" belongs to maxHeap, decrement maxHeap size to:" + miniHeapSize);
            // If the removed number is the root of miniHeap, prune it
            if (num == maxHeap.peek()) {
                System.out.println("if the removed number is the root of maxHeap, prune it.");
                prune(maxHeap);
            }else {
                System.out.println("the removed number is not the root of the maxHeap. No need to prune.");
            }
        } else {
            --maxHeapSize;
            System.out.println( num +" belongs to minHeap, decrement minHeap size to:" + maxHeapSize);
            // If the removed number is the root of maxHeap, prune it
            if (num == miniHeap.peek()) {
                System.out.println("the removed number is the root of miniHeap, prune it");
                prune(miniHeap);
            }else{
                System.out.println("the removed number is not the root of miniHeap. NO need to prune.");
            }
        }
        // Re-balance the heaps if necessary
        rebalance();
    }

    // Method to prune delayed elements from the heaps
    private void prune(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {
            System.out.println("the root val is in the map and its value in map is : " + delayed.get(pq.peek()));
            // Decrement the count of the number in the delayed map
            if (delayed.merge(pq.peek(), -1, Integer::sum) == 0) {
                System.out.println("decremented value:" +pq.peek() + " and removed from map if it reaches zero." );
                // If the count becomes zero, remove the number from the delayed map
                delayed.remove(pq.peek());
            }
            // Remove the number from the heap
            System.out.println("also removing the value from the heap");
            pq.poll();
        }
    }

    // Method to rebalance the heaps
    private void rebalance() {
        // If miniHeap is larger than maxHeap by more than one element,
        // move the root of miniHeap to maxHeap
        System.out.println("checking for balancing the heaps");
        if (miniHeapSize > maxHeapSize + 1) {
            miniHeap.offer(maxHeap.poll());
            System.out.println("maxHeap is greater in size by more than one");
            --miniHeapSize;
            ++maxHeapSize;
            System.out.println("maxHeap and minHead sizes changed to:" + miniHeapSize +" and " + maxHeapSize + " respectively");
            // Prune the miniHeap
            System.out.println("pruning maxHeap since it had a greater size");
            prune(maxHeap);
        }
        // If maxHeap is larger than miniHeap, move the root of maxHeap to miniHeap
        else if (miniHeapSize < maxHeapSize) {
            maxHeap.offer(miniHeap.poll());
            System.out.println("min Heap is greater in size.");
            --maxHeapSize;
            ++miniHeapSize;
            System.out.println("maxHeap and minHead sizes changed to:" + miniHeapSize +" and " + maxHeapSize + " respectively");
            // Prune the maxHeap
            System.out.println("pruning minHeap since it had a greater size");
            prune(miniHeap);
        }
    }
}

class Solution {
    // Method to find the median of each sliding window
    public double[] medianSlidingWindow(int[] nums, int k) {
        FindMedianWindow finder = new FindMedianWindow(k);
        // Initialize the medianFinder with the first window of size k
        for (int i = 0; i < k; ++i) {
            finder.addNum(nums[i]);
        }
        int n = nums.length;
        // Array to store the medians of each window
        double[] ans = new double[n - k + 1];
        // Calculate the median for the first window
        ans[0] = finder.findMedian();
        // Slide the window and calculate median for each subsequent window
        for (int i = k; i < n; ++i) {
            finder.addNum(nums[i]);
            finder.removeNum(nums[i - k]);
            ans[i - k + 1] = finder.findMedian();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        Solution solution = new Solution();
        double[] ans = solution.medianSlidingWindow(nums, k);

        System.out.println("Resulting array:");
        for (double num : ans) {
            System.out.print(num + " ");
        }
    }

}