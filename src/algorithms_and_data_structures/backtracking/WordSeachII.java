package algorithms_and_data_structures.backtracking;

import java.util.*;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class WordSeachII {
    class Node{
        boolean isEndOfWord;
        Map<Character, Node> children;
        Node(){
            isEndOfWord = false;
            children = new HashMap<>();
        }
    }

    private  Node insertWords(String[] words){
        Node root = new Node();
        for(String word: words){
            Node current = root;
            for(char c : word.toCharArray()){
                if(!current.children.containsKey(c)){
                    current.children.put(c, new Node());
                }
                current = current.children.get(c);
            }
            current.isEndOfWord = true;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words){
        Set<String> solution = new HashSet<>();

        Node current = insertWords(words);

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i, j, "", current, visited, solution,  board);
            }
        }

        return new ArrayList<>(solution);
    }

    private  void dfs(int i, int j, String word, Node current, boolean[][] visited, Set<String> solution, char[][] board){
        if(current.isEndOfWord){
            solution.add(word);
        }
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length -1  || visited[i][j] || !current.children.containsKey(board[i][j])){
            return;
        }
        visited[i][j] = true;
        current = current.children.get(board[i][j]);
        word += board[i][j];

        dfs(i + 1, j , word, current, visited, solution, board);
        dfs(i - 1, j , word, current, visited, solution, board);
        dfs(i , j + 1, word, current, visited, solution, board);
        dfs(i , j - 1 , word, current, visited, solution, board);

        visited[i][j] = false;
        /**
         * time: O(L * N + m * n * 4 ^ L) , first term is for building the trie. Second term is for the recursion.
         * space: O(N + L + m* n). : O(N) for building the trie. And O(L) for the recursion stack. We can also add the visited array of size m *n
         */
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSeachII wordSearch = new WordSeachII();
        List<String> result = wordSearch.findWords(board, words);

        for (String word : result) {
            System.out.println(word);
        }
    }
}
