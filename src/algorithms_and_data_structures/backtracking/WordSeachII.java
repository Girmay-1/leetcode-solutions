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
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }



    public List<String> findWords(char[][] board, String[] words){
        //populate the TrieNode
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode currentNode = root;
            for(char c: word.toCharArray()){
                int index = c - 'a';
                if(currentNode.children[index] == null){
                    currentNode.children[index] = new TrieNode();
                }
                currentNode = currentNode.children[index];
            }
            currentNode.word = word;
        }

        List<String> solution = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i, j, root, solution, board);
            }
        }

        return  solution;
    }

    private void dfs(int i, int j, TrieNode currentNode, List<String> solution, char[][] board) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
            board[i][j] == '#' || currentNode.children[board[i][j] - 'a'] == null){
            return;
        }
        char c = board[i][j];
        currentNode = currentNode.children[c - 'a'];
        if(currentNode.word != null){
            solution.add(currentNode.word);
            currentNode.word = null; //to avoid duplicates since we are using list (set would have removed this)
        }
        board[i][j] = '#'; //mark visited;

        dfs(i + 1, j, currentNode, solution, board);
        dfs(i - 1, j, currentNode, solution, board);
        dfs(i,j + 1, currentNode, solution, board);
        dfs(i,j - 1, currentNode, solution, board);

        board[i][j] = c;

        /**
         * time: O(N * L) +O(M * N * L ^ 4) where L is the av. len of a word, M,N = number of words
         * space: O(N * L) + O(L) (trie + recursive stack)
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
