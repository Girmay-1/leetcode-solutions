package algorithms_and_data_structures.slidingwindow;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * You are given an integer array nums and two integers indexDiff and valueDiff.
 *
 * Find a pair of indices (i, j) such that:
 *
 * i != j,
 * abs(i - j) <= indexDiff.
 * abs(nums[i] - nums[j]) <= valueDiff, and
 * Return true if such pair exists or false otherwise.
 */
public class ContainsDuplicatesIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        NavigableSet<Integer> teeSet = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            Integer floor = teeSet.floor(nums[i] + valueDiff);
            Integer ceiling = teeSet.ceiling(nums[i] - valueDiff);

            if(floor != null && nums[i] <= floor || ceiling != null && nums[i] >= ceiling){
                return true;
            }
            teeSet.add(nums[i]);
            //sliding window.
            if(teeSet.size() > indexDiff){
                teeSet.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicatesIII containsDuplicatesIII = new ContainsDuplicatesIII();
        int[] nums = {1,2,3,1};

        System.out.println(containsDuplicatesIII.containsNearbyAlmostDuplicate(nums,3, 0)   );
    }
}
