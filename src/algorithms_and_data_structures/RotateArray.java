package algorithms_and_data_structures;

public class RotateArray {
    /**
     * this is to rotate an array by k unites to the right; and the one below it to rotate left;
     */
    public void rotateright(int[] nums, int k) {

        k = k%(nums.length);

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void rotateleft(int[] nums, int k){
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int last = nums[end];
            nums[end] = nums[start];
            nums[start] =  last;
            end--;
            start++;
        }

    }

}
