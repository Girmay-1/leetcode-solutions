public class JumpsGame {
    /**
     * returns the minimum jump to reach nums[n -1] where n is the number of elements. This solution is kind of BFS.
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int furthest = 0;
        int jump = 0;
        //to handle the case where the array has only one element
        if(nums.length <= 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (furthest >= nums.length - 1) {
                jump++;
                break;
            }
            if (end == i) {
                end = furthest;
                jump++;
            }
        }
        return jump;
    }
}
