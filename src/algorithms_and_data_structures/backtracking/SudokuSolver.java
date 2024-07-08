package algorithms_and_data_structures.backtracking;

public class SudokuSolver {
    public void solveSudoku(char[][] board){
        if(board == null || board.length != 9 || board[0].length != 9){
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {

        for(int i = 0; i  < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(i, j, c, board)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char c, char[][] board) {
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c || board[i][col] == c || board[3 * (row/3) + i/3][3 * (col/3) + i % 3] == c){
                return false;
            }
        }
        return true;
    }

    //time: O(9 ^ n ^2) worst case scenario = ~ O(9 ^9 ^2) ~ O(1).
    //space: O(9 * 9) ~O(1)
}








