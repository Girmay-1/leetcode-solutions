package algorithms_and_data_structures.backtracking;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class PlaceQueens {
    public static void main(String[] args){
        PlaceQueens placeQueens = new PlaceQueens();

        System.out.println(placeQueens.totalNQueens(4));
    }

    int totalSolutions = 0;
    public int totalNQueens(int n){
        int[] queens = new int[n];
        placeQueens(0, queens);
        return totalSolutions;
    }

    private void placeQueens(int row, int[] queens) {
        if(row == queens.length){
            totalSolutions++;
        }else{
            for(int j = 0; j < queens.length; j++){
                if(allowed(j, queens, row)){
                    queens[row] = j;
                    placeQueens(row + 1, queens);
                }
            }
        }
    }

    private boolean allowed(int j, int[] queens, int row) {
        for(int i = 0; i < row; i++){
            if(queens[i] == j || queens[i] == j - (row - i) || queens[i] == j + (row - i)){
                return false;
            }
        }
        return true;
    }
}
