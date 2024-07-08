package algorithms_and_data_structures.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
public class PlaceQueensII {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        placeQueen(0, new int[n], solution);
        return solution;

    }

    private void placeQueen(int row, int[] queens, List<List<String>> solution) {
        if(row == queens.length){
            solution.add(generateList(queens));
            return;
        }else{
            for(int column = 0; column < queens.length; column++){
                if(allowed(column, row, queens)){
                    queens[row] = column;
                    placeQueen(row + 1, queens, solution);
                }
            }
        }
    }

    private boolean allowed(int column, int row, int[] queens) {
        for(int r = 0; r < row; r++){
            if(queens[r] == column || queens[r] == column - (row - r) || queens[r] == column + (row - r)){
                return false;
            }
        }
        return true;
    }

    private List<String> generateList(int[] queens) {
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < queens.length; i++){
          char[] chars = new char[queens.length];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            stringList.add(new String(chars));
        }

        return stringList;
    }
}
