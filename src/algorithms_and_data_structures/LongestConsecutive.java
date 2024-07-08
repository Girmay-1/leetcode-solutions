package algorithms_and_data_structures;

import java.util.HashSet;
import java.util.Set;

/**
 * this is amazing
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int count = 0;
        int length = 0;
        int longest = 0;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);

        }


        for (Integer element : set){
            if (!set.contains(element - 1 )){
                length = 0;
                while(set.contains(element + length)){
                    length++;
                    longest = Math.max(length, longest);
                }
            }
        }
        return longest;
    }
}
