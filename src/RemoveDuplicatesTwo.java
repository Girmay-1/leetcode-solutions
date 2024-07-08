public class RemoveDuplicatesTwo {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            }
            //this is important since we have to reset every count with every interation.
            else{
                count = 1;
            }
            if (count <= 2){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
