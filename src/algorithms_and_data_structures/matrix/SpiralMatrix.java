package algorithms_and_data_structures.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> solution = new ArrayList<>();
        int n = matrix.length;

        if(n == 0){
            return solution;
        }

        int m = matrix[0].length;

        int row = 0;
        int col = 0;

        while(row < n && col < m){
            for(int j = col; j < m; j++){
                solution.add(matrix[row][j]);
            }
            row++;

            for(int i = row; i < n; i++){
               solution.add(matrix[i][m -1]);
            }
            m--;
            if(col < m){
                for(int j = m - 1; j >= col; j--){
                    solution.add(matrix[n - 1][j]);
                }
                n--;
            }
            if(row < n){
                for(int i = n - 1; i >= row; i--){
                    solution.add(matrix[i][col]);
                }
                col++;
            }

        }
       return solution;
    }
    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        //example of printing arrays
        int[] arrays = new int[]{234, 43, 4};
        System.out.println(Arrays.toString(arrays));

        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println("Spiral order traversal: " + result);
    }
}
