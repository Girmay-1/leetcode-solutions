package algorithms_and_data_structures.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * time : O(klogk)
 * space: O(k)
 */
public class SmallestSumPair {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> soln = new ArrayList<>();
        PriorityQueue<int[]> miniHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for(int i = 0; i < k && i < nums1.length; i++){
            miniHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while(k-- > 0 && !miniHeap.isEmpty()){
            int[] current = miniHeap.poll();
            soln.add(Arrays.asList(current[0], current[1]));
            if(current[2] == nums2.length - 1){ //nums2 reached limit
                continue;
            }
            miniHeap.offer(new int[]{current[0], nums2[current[2] + 1], current[2] + 1}); // Move to the next index in nums2
        }
        return soln;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};

        int k = 3;
        SmallestSumPair smallestSumPair = new SmallestSumPair();
        List<List<Integer>> result = smallestSumPair.kSmallestPairs(nums1, nums2, k);

        System.out.println("K Pairs with Smallest Sums:");

        System.out.println(result);


    }

}
