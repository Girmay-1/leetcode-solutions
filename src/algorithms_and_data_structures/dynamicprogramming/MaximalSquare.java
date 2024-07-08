package algorithms_and_data_structures.dynamicprogramming;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
    public int maximalSquareDynamically(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int maxLenSquare = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxLenSquare = Math.max(maxLenSquare, dp[i][j]);
                }
            }
        }

        return maxLenSquare * maxLenSquare;
    }

    public int maximalSquareRecusrively(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxLenSquqre = 0;
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maxLenSquqre = Math.max(maxLenSquqre, getMaxSquareValue(i, j, matrix));
                }
            }

        }
        return maxLenSquqre * maxLenSquqre;
    }

    private int getMaxSquareValue(int i, int j, char[][] matrix) {
        if(i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || matrix[i][j] == '0'){
            return 0;
        }
        int down = getMaxSquareValue(i + 1, j, matrix);
        int right = getMaxSquareValue(i, j + 1, matrix);
        int diagonal = getMaxSquareValue(i + 1, j + 1, matrix);

        return  1 + Math.min(Math.min(down, right), diagonal);
    }

    public static void main(String[] args) {

            MaximalSquare solution = new MaximalSquare();

            // Example test case
            char[][] matrix = {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            };
            int maxSquareArea = solution.maximalSquareDynamically(matrix);
        System.out.println("Maximum square area dynamically: " + maxSquareArea);
            int maxSquareArea1 = solution.maximalSquareRecusrively(matrix);
            System.out.println("Maximum square area recursively: " + maxSquareArea1);

    }

}