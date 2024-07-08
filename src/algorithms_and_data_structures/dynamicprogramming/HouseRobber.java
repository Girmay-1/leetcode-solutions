package algorithms_and_data_structures.dynamicprogramming;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security systems connected, and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
 * rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for(int num: nums){
            int temp = rob2;
            rob2 = Math.max(rob1 + num, rob2);
            rob1 = temp;
        }
        return rob2;
    }

    // time: O(n)

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {1,2,3,1};
        System.out.println(houseRobber.rob(nums));
    }
}
