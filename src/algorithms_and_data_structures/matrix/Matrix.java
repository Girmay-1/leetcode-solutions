package algorithms_and_data_structures.matrix;

import java.util.HashMap;
import java.util.Map;

public class Matrix {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Map<Integer,Integer> countMap = checkLiveDeadCount(board, i, j, m, n);
                if(board[i][j] == 1 && (countMap.containsKey(1) && (countMap.get(1) < 2 || countMap.get(1) > 3))) {
                    newBoard[i][j] = 0;
                } else if(board[i][j] == 1 && (countMap.containsKey(1) && (countMap.get(1) == 2 || countMap.get(1) == 3))){
                        newBoard[i][j] = 1;
                    }else if(board[i][j] == 0 && (countMap.containsKey(1) && countMap.get(1) == 3)){
                    newBoard[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = newBoard[i][j];
            }
        }



    }

    public Map<Integer,Integer> checkLiveDeadCount(int[][] board, int i, int j, int row, int col){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int startRow = Math.max(0,i - 1); startRow <= Math.min(row -1, i + 1); startRow++){
            for(int startCol = Math.max(0,j - 1); startCol <= Math.min(col - 1, j + 1); startCol++){

                if(!(startRow == i && startCol == j)){
                    System.out.println(startRow + ":" + startCol);
                    countMap.put(board[startRow][startCol], countMap.getOrDefault(board[startRow][startCol], 0) + 1);
                }
            }
        }
        return countMap;

    }

    public static void main(String[] args) {

            Matrix solution = new Matrix();

            // Test input board
            int[][] board = {
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0}
            };
        System.out.println("original:" );
        printBoard(board);
            solution.gameOfLife(board);
        System.out.println("Updated Board:");
        printBoard(board);
    }
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
