package algorithms_and_data_structures.stringsandarrays;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int steps = 0;
        int maxJump = 0;
        int endLastJump = 0;
        for(int i = 0; i < nums.length ; i++){
            maxJump = Math.max(maxJump, i + nums[i]);
            if(maxJump >= nums.length - 1){
                steps++;
                break;
            }
            System.out.println("maxJum:" + maxJump);
            if(endLastJump == i){
                System.out.println("endLastJump:" + endLastJump + "maxJump" + maxJump);
                endLastJump = maxJump;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        JumpGameII jumpGameII = new JumpGameII();
        int sol = jumpGameII.jump(nums);
        System.out.println("steps:" + sol);
    }
}
