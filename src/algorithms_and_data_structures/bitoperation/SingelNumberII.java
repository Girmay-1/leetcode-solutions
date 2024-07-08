package algorithms_and_data_structures.bitoperation;

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingelNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones ^= num & ~twos;
            twos ^= num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        SingelNumberII singelNumberII = new SingelNumberII();
        int[] nums = {2, 2, 3, 2};
        System.out.println(singelNumberII.singleNumber(nums));
    }
    //time: O(n) and space: O(1)
 }
