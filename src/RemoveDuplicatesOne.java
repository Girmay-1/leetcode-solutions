public class RemoveDuplicatesOne {
    public int removeDulicates(int[] nums){
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[index] =  nums[i];
                index++;
            }

        }
        return index;
    }
}
