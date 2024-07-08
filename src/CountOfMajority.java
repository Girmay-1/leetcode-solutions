import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * majority is an element that appears more than (array len)/2. Here is a solution in O(n);
 */
public class CountOfMajority {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapOfElementsCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            mapOfElementsCount.put(nums[i], mapOfElementsCount.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: mapOfElementsCount.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    //easy way
    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
