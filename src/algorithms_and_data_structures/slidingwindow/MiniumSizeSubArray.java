package algorithms_and_data_structures.slidingwindow;

/**
 * there are two ways to solve this problem. One is sliding window with a running time of O(n). Another is
 * using binary search with a running time O(nlogn) and space O(n).
 */
public class MiniumSizeSubArray {
    public int minimumSubArrayLen1(int[] nums, int target){
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        int left = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];

            while(sum >= target){
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        MiniumSizeSubArray miniumSizeSubArray = new MiniumSizeSubArray();
        System.out.println(miniumSizeSubArray.minimumSubArrayLen1(nums, target));
        System.out.println(miniumSizeSubArray.minimumSubArrayLen2(nums, target));
    }

    private int minimumSubArrayLen2(int[] nums, int target) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // Compute the prefix sum array
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int minLength = Integer.MAX_VALUE;

        // Iterate over each element and binary search for the rightmost index
        for (int i = 1; i <= n; i++) {
            int left = i;
            int right = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int sum = prefixSum[mid] - prefixSum[i - 1];

                if (sum >= target) {
                        minLength = Math.min(minLength, mid - i + 1);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}
