package algorithms_and_data_structures.stringsandarrays;

public class RotateArray {
    //using O(1) space
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //reverse the entire array;
        reverse(nums, 0, n - 1);
        //reverse the first k elements
        reverse(nums, 0, k - 1);
        //reverse the rest of the elements
        reverse(nums, k , n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right){
            int last = nums[right];
            nums[right] = nums[left];
            nums[left] = last;
            left++;
            right--;
        }
    }
    //using O(n) space:
    public void rotateArray(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        int[] rotatedArray = new int[nums.length];
        //copy the last k elements to the array
        System.arraycopy(nums,n - k, rotatedArray,0, k);
        //copy the remaining elements to the array
        System.arraycopy(nums,0, rotatedArray,k - 1, n - k);
        //copy the elements back to the original array. Now you have rotated array by k units.
        System.arraycopy(rotatedArray, 0, nums, 0, n);
    }
}
