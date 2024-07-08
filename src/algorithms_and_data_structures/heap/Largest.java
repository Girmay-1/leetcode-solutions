package algorithms_and_data_structures.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 */
public class Largest {
    public int findKthUsingSorting(int[] nums, int k){
        //but this is not efficient for very large arrays. Time complexity is O(NlogN)
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public int findKthUsingHeap(int[] nums, int k){

        // time O(nlogk);
        //space O(k)
        PriorityQueue<Integer> miniHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            miniHeap.offer(nums[k]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] > miniHeap.peek()){
                miniHeap.poll();
                miniHeap.offer(nums[i]);
            }
        }
        return miniHeap.peek();
    }

    /**
     * quick select is th most interesting solution. If you are trying to find kth smallest, pass k, if you are trying to find kth largest, pass len - k as rank.
     *
     * basically the algorithm is partitioning  the array where every element to the left of the pivot is smaller than the pivot(order doesn't matter. So imagine if the index of the pivot == len - k. That's our solution.
     * bestCase: time O(n) and worst case: O(n^2)
     * space: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthQuickSelect(int[] nums, int k){

        int low = 0;
        int high = nums.length - 1;
        int rank = nums.length - k;
            return quickSelect(low, high, nums, rank);
    }


    private int quickSelect(int low, int high, int[] nums, int rank) {
        if(low <= high){
            int index = partition(low, high, nums);
            if(index == rank){
                System.out.println("index: " + rank);
                return nums[rank];
            }else if(index < rank){
                return quickSelect(index + 1, high, nums, rank);
            }else{
                return quickSelect(low, index - 1, nums, rank);
            }
        }
       return -1;
    }

    private int partition(int low, int high, int[] nums) {
        int pivot = nums[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(nums[j] < pivot){
                i++;
                swap(i, j , nums);
            }
        }
        swap (i + 1, high, nums);
        return i + 1;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int k = 2;
        Largest largest= new Largest();
        int kthLargest = largest.findKthUsingSorting(nums, k);
        System.out.println("Kth Largest Element method 1:  " + kthLargest);
        kthLargest = largest.findKthUsingHeap(nums, k);
        System.out.println("Kth Largest Element method 2:  " + kthLargest);
        kthLargest = largest.findKthQuickSelect(nums, k);
        System.out.println("Kth Largest Element method 3:  " + kthLargest);
    }

}
