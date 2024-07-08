package algorithms_and_data_structures.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(sol, new ArrayList<>(), nums, new boolean[nums.length]);
        return sol;
    }

    private void backTrack(List<List<Integer>> sol, ArrayList<Integer> arr, int[] nums, boolean[] used) {
        if(arr.size() == nums.length){
            sol.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                arr.add(nums[i]);
                used[i] = true;
                backTrack(sol, arr, nums, used);
                arr.remove(arr.size() - 1);
                used[i] = false;
            }
        }
    }
}
