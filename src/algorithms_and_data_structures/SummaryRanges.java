package algorithms_and_data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Example :
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> sol = new ArrayList<>();
        if(nums.length < 1){
            return sol;
        }

        int start = nums[0];
        int end  = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                end = nums[i];
                continue;
            }
            if(end != start){
                sol.add(start + "->" + end);
            }else{
                sol.add(String.valueOf(start));
            }
            start = end = nums[i];
        }
        if(end != start){
            sol.add(start + "->" + end);
        }else{
            sol.add(String.valueOf(start));
        }

      return sol;
    }

}
