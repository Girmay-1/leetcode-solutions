package algorithms_and_data_structures.binarysearch;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindMin {
    public int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(left <= right){
            if(nums[left] <= nums[right]){
                min = Math.min(min, nums[left]);
                break;
            }
            int mid = (left + right) / 2;

            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums = {4,5, 0, 1, 3};
        System.out.println("min value:" + findMin.findMin(nums));
    }
}
