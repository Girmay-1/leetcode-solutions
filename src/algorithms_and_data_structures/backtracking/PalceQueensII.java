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
public class PalceQueensII {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        int[] queens = new int[n];
        placeQueens(0, queens, solution);
        return solution;
    }

    private void placeQueens(int row, int[] queens, List<List<String>> solution) {
        if(row == queens.length){
            solution.add(new ArrayList<>(populateList(queens)));
            return;
        }else {
            for(int col = 0; col < queens.length; col++){
                if(allowed(row, col, queens)){
                    queens[row] = col;
                    placeQueens(row + 1, queens, solution);
                }
            }
        }
    }

    private boolean allowed(int row, int col, int[] queens) {
        for(int i = 0; i < row; i++){
            if(queens[i] == col || queens[i] == col + (row - i) || queens[i] == col - (row - i)){
                return false;
            }
        }
        return true;
    }

    private List<String> populateList(int[] queens) {
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < queens.length; i++){
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            arr.add(new String(row));
        }
        return arr;
    }
//time: n!, space n * n.
}
