package algorithms_and_data_structures.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] solution = new int[nums.length - k + 1];
        if( nums.length == 0 || k == 0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            //remove elements from the front if length is greater than the window.
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            //// Remove indices of elements smaller than the current element from the last.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            //add the index to the queue.
            deque.offer(i);

            //Add the maximum element (the front of the deque) to the result array give that i has crossed the minimum array size.
            if(i >= k - 1){
                solution[i - k + 1] = nums[deque.peek()];
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        MaxSlidingWindow slidingWindow = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = slidingWindow.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
