package algorithms_and_data_structures.binarysearch;

/**
 * find the minimum in a rotated array
 * you must write an algorithm that runs in O(log n) time.
 */
public class MInimumRotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if(nums[start] < nums[end]){
            return nums[start];
        }

        while (start < end){
            int mid = (start + end) / 2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return  nums[start];
    }

    public static void main(String[] args) {
        MInimumRotatedArray solution = new MInimumRotatedArray();
        // Test cases
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Minimum in nums1: " + solution.findMin(nums1)); // Output: 1
        System.out.println("Minimum in nums2: " + solution.findMin(nums2)); // Output: 0
        System.out.println("Minimum in nums3: " + solution.findMin(nums3)); // Output: 11
    }
}
