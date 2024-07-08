package algorithms_and_data_structures.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParanthesis(int n){
        List<String> solution = new ArrayList<>();
        backTrack(0, 0, "", n, solution);
        return solution;
    }

    private void backTrack(int open, int closed, String s, int n, List<String> solution) {
        System.out.println(s);
        System.out.print("Open: " + open);
        System.out.println(", closed: " + closed);
        if(open == n && closed == n){
            solution.add(s);
            return;
        }
        if(open < n){

            backTrack(open + 1, closed, s + "(", n, solution);

        }
        if(closed < open){

            backTrack(open, closed + 1, s + ")", n , solution);
        }
    }

    public static void main(String[] args) {
        GenerateParanthesis generateParanthesis = new GenerateParanthesis();
        System.out.println(generateParanthesis.generateParanthesis(3));
    }
}
