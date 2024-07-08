package algorithms_and_data_structures.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solution = new ArrayList<>();

        if ( k == 0 || n == 0)
            return solution;
         combination(1, n, k, new ArrayList<>(), solution);
         return solution;
    }

    private void combination(int start, int n, int k, ArrayList<Integer> arr, List<List<Integer>> solution) {
        if(k == 0){
            solution.add(new ArrayList<>(arr));
            return;
        }
        for(int i = start; i <= n; i++) {
            arr.add(i);
            combination(i + 1, n, k - 1, arr, solution);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination comb = new Combination();
        System.out.println(Arrays.toString(new List[]{comb.combine(4, 2)}));
    }
}
