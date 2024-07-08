package algorithms_and_data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backTrack(1, k, n, result, arr);
        return result;

    }
    private void backTrack(int index, int k, int n, List<List<Integer>> result, List<Integer> arr){
       if(k == 0){
           result.add(new ArrayList<>(arr));
           return;
       }
       for(int i = index; i <= n; i++){
           arr.add(i);
           backTrack(i + 1, k - 1, n , result ,arr);
           arr.remove(arr.size() - 1);

       }
    }
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combinations.combine(n, k);
        System.out.println("Combinations of " + n + " choose " + k + ": ");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        }
    // time complexity: number of combinations : O(C(n, k));
    //space : number of combinations * k: O(k * C(n, k));
}
