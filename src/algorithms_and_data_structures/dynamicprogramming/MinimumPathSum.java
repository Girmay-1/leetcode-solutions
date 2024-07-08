package algorithms_and_data_structures.dynamicprogramming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        int[][] memo = new int[m][n];

        memo[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            memo[0][j] = memo[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                memo[i][j] = grid[i][j] + Math.min(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m - 1][n - 1];
    }
    //improved space complexity:
    public int minPathSum2(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[] memo = new int[m];
        memo[0] = grid[0][0];

        for(int i = 0; i < m; i++){
            memo[i] = memo[i - 1] + grid[0][i];
        }

        for(int i = 1; i < n; i++){
            memo[0] = memo[0] + grid[i][0];
            for(int j = 1; j < m; j++){
              memo[j] = Math.min(memo[j - 1], memo[j]) + grid[i][j];
            }
        }

        return memo[m - 1];
    }
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MinimumPathSum solution = new MinimumPathSum();

        System.out.println("Test Case 1:");
        System.out.println("Expected Output: 7");
        System.out.println("Actual Output: " + solution.minPathSum(grid1));
        System.out.println();

        System.out.println("Test Case 2:");
        System.out.println("Expected Output: 21");
        System.out.println("Actual Output: " + solution.minPathSum(grid2));
    }
}
