package algorithms_and_data_structures.stringsandarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> elementsMap = new HashMap<>();
        for(int num: nums){
            elementsMap.put(num, elementsMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : elementsMap.entrySet()){
            if(entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * another way is, and important, to use O(1) space complexity. The below algorithm is called Boyer Moore Majority Vote algorithm.
     */
    public int majorityElement2(int[] nums){
        int count = 0;
        Integer candidate = null;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate)? 1: -1;
        }


        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int solution1 = majorityElement.majorityElement(nums);
        System.out.println("using hashMap:" + solution1);
        int solution2 = majorityElement.majorityElement2(nums);
        System.out.println("using majority vote algorith: "+ solution2);
    }
}
