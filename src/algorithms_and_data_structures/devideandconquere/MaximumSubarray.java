package algorithms_and_data_structures.devideandconquere;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *  this is easily achieved using Kadane's Algorithm (O(n) time and O(1) space:
 *
 *
 *  But this below devide and conquer has time: nlogn and space logn due to recursion
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null)
            return 0;

        return findMaxSubArray(nums, 0, nums.length - 1);
    }

    private int findMaxSubArray(int[] nums, int start, int end) {
        if(start == end)
            return nums[start];
        if(start > end)
            return 0;
        int mid = (start + end) / 2;
        System.out.println("mid value:" + nums[mid]);
        int leftSum = findMaxSubArray(nums, start, mid - 1);
        System.out.println("leftSum:" + leftSum);
        int righSum = findMaxSubArray(nums, mid + 1, end);
        System.out.println("rightSum:" + righSum);
        int crossSum = findCrossSum(nums, start, mid, end);
        System.out.println("crossSum:" + crossSum);

        return Math.max(Math.max(leftSum, righSum), crossSum);
    }

    private int findCrossSum(int[] nums, int start, int mid, int end) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        int sum = 0;
        for(int i = mid; i >= start; i--){
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        for(int i = mid + 1; i <= end; i++){
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.maxSubArray(nums));
    }
}
