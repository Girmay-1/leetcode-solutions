package algorithms_and_data_structures.dynamicprogramming;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given a 0-indexed m x n integer matrix grid. Your initial position is at the top-left cell (0, 0).
 *
 * Starting from the cell (i, j), you can move to one of the following cells:
 *
 * Cells (i, k) with j < k <= grid[i][j] + j (rightward movement), or
 * Cells (k, j) with i < k <= grid[i][j] + i (downward movement).
 * Return the minimum number of cells you need to visit to reach the bottom-right cell (m - 1, n - 1). If there is no valid path, return -1.
 */
public class MinimumVisitedCells {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 1 && n == 1){
            return 1;
        }

        int[][] jump = new int[m][n];

        for(int[] row : jump){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]>[] col = new PriorityQueue[n];

        for(int j = 0; j < n; j++){
            col[j] = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        }

        //initialize jump array;
        jump[0][0] = 1;

        for(int i = 0; i < m; i++){
            PriorityQueue<int[]> row = new PriorityQueue<>((a , b) -> a[0] - b[0]);
            for(int j = 0; j < n; j++){
                //check horizontal movement
                while(!row.isEmpty() && j > (grid[i][row.peek()[1]] + row.peek()[1])){
                    row.poll();
                }
                if(!row.isEmpty()){
                    jump[i][j] = Math.min(jump[i][j], row.peek()[0] + 1);
                }
                //vertical movement
                while(!col[j].isEmpty() && i > (grid[col[j].peek()[1]][j] + col[j].peek()[1])){
                    col[j].poll();
                }
                if(!col[j].isEmpty()){
                    jump[i][j] = Math.min(jump[i][j], col[j].peek()[0] + 1);
                }
                //populate the heaps if the given row and column in reachable.
                if(jump[i][j] != Integer.MAX_VALUE){
                    row.offer(new int[]{jump[i][j], j});
                    col[j].offer(new int[]{jump[i][j], i});
                }
            }
        }

        return jump[m - 1][n - 1] != Integer.MAX_VALUE? jump[m - 1][n - 1]: -1;
    }

    public static void main(String[] args) {
        MinimumVisitedCells solution = new MinimumVisitedCells();

        // Test case 1
        int[][] grid1 = {{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}};
        System.out.println("Test case 1 output: " + solution.minimumVisitedCells(grid1));
        // Expected output: 4

        // Test case 2
        int[][] grid2 = {{3, 4, 2, 1}, {4, 2, 1, 1}, {2, 1, 1, 0}, {3, 4, 1, 0}};
        System.out.println("Test case 2 output: " + solution.minimumVisitedCells(grid2));
        // Expected output: 3

        // Test case 3
        int[][] grid3 = {{2, 1, 0}, {1, 0, 0}};
        System.out.println("Test case 3 output: " + solution.minimumVisitedCells(grid3));
        // Expected output: -1

        // Test case 4 (1x1 grid)
        int[][] grid4 = {{0}};
        System.out.println("Test case 4 output: " + solution.minimumVisitedCells(grid4));
        // Expected output: 1
        }

}
