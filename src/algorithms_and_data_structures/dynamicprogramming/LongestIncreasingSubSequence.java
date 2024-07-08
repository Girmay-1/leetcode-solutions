package algorithms_and_data_structures.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    /**
     * using dynamic progeramming. Time: O(n ^ 2) and space = O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = 1;
        for(int val: dp){
            max = Math.max(max, val);
        }
        return max;
    }

    /**
     * using backtracking. Time: O(2 ^ n) and space: O(n) + recursion
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums){
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int[] A = new int[nums.length + 1];
        Arrays.fill(A, Integer.MIN_VALUE);
        System.arraycopy(nums, 0, A, 1, nums.length);
        return findLIS(A, 0, 1);
    }

    private int findLIS(int[] a, int i, int j) {
        int n = a.length;
        if(j >= n){
            return 0;
        }
        else if(a[i] >= a[j]){
            return findLIS(a, i, j + 1);
        }else {
            int include = findLIS(a, j, j + 1) + 1;
            int skip = findLIS(a, i, j + 1);

            return Math.max(include, skip);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 7, 3, 8, 4, 9};
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        System.out.println(lis.lengthOfLIS1(nums));
        System.out.println(lis.lengthOfLIS2(nums));
    }
}
