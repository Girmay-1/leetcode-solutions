package algorithms_and_data_structures.backtracking.ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 */
public class Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> sol = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return sol;
        }

        int start = nums[0];

        for(int i = 1; i <= nums.length; i++){
            if(i == nums.length || nums[i] != nums[i - 1] + 1){
                if(start != nums[i - 1]){
                    sol.add(start + "->" + nums[i - 1]);
                }else{
                    sol.add(String.valueOf(start));
                }
                if(i < nums.length){
                    start = nums[i];
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        Ranges ranges = new Ranges();
        // Test case 1
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(ranges.summaryRanges(nums1));  // Output: ["0->2", "4->5", "7"]

        // Test case 2
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(ranges.summaryRanges(nums2));  // Output: ["0", "2->4", "6", "8->9"]

        // Test case 3
        int[] nums3 = {};
        System.out.println(ranges.summaryRanges(nums3));  // Output: []

        // Test case 4
        int[] nums4 = {-1};
        System.out.println(ranges.summaryRanges(nums4));  // Output: ["-1"]

        // Test case 5
        int[] nums5 = {0};
        System.out.println(ranges.summaryRanges(nums5));  // Output: ["0"]
    }

}
