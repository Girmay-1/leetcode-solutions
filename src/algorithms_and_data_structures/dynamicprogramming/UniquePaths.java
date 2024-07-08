package algorithms_and_data_structures.dynamicprogramming;

public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];

        boolean obstacle = false;

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacle = true;
            }
            if (!obstacle) {
                memo[i][0] = 1;

            } else {
                memo[i][0] = 0;
            }
        }
        obstacle = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacle = true;
            }
            if (!obstacle) {
                memo[0][j] = 1;
            } else {
                memo[0][j] = 0;
            }

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = obstacleGrid[i][j] == 1 ? 0 : memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[m - 1][n - 1];
    }
}

