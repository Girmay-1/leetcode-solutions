package algorithms_and_data_structures.paranthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class GenerateParanthesis {
    /**
     * this is going to be solved using backtracking
     */

    public List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList<>();
        helper("", 0, 0, n, solution);
        return solution;
    }

    private void helper(String s, int open, int close, int n, List<String> solution) {
        if(open == n && close == n){
            solution.add(s);
        }
        if(open < n){
            helper(s + "(", open + 1, close, n, solution);
        }
        if(close < open){
            helper(s + ")", open, close + 1, n, solution);
        }
    }

    public static void main(String[] args) {
            GenerateParanthesis solution = new GenerateParanthesis();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println("Generated parentheses combinations:");
        for (String s : result) {
            System.out.println(s);
        }


    }
}
