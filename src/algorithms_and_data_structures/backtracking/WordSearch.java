package algorithms_and_data_structures.backtracking;

/**
 *
 Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Constraints:

 m == board.length
 n = board[i].length
 1 <= m, n <= 6
 1 <= word.length <= 15
 board and word consists of only lowercase and uppercase English letters.
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(i, j, 0, visited, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, boolean[][] visited, String word, char[][] board) {
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i > board.length - 1|| j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        visited[i][j] = true;

       boolean res = dfs(i + 1, j, index + 1, visited, word, board) ||
        dfs(i - 1, j, index + 1, visited, word, board)||
        dfs(i , j + 1, index + 1, visited, word, board)||
        dfs(i , j - 1, index + 1, visited, word, board);


       visited[i][j] = false;

       return res;

        /**
         * time :   time = > O(m * n * 4 ^ L) where L is the length of the word.
         * space = O(m * n) [memory consumed by the visited array] plus recursive calls., which is insignificant.  maximum depth of the recursion stack is
         * L(which is equal to the maximum length of a word),
         */


    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCED")); // true
        System.out.println(wordSearch.exist(board, "SEE"));    // true
        System.out.println(wordSearch.exist(board, "ABCB"));   // false
    }
}
