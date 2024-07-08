package algorithms_and_data_structures.dynamicprogramming;

import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class TextSegmentation {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        memo[n] = true;
        for(int i = n - 1; i >= 0; i--){
            memo[i] = false;
            for( int j = i; j < n; j++){
                if(isWord(i, j + 1,s, wordDict) && memo[j + 1]){
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[0];
    }

    private boolean isWord(int i, int j, String s, List<String> wordDict) {
        String word = s.substring(i, j);
        return wordDict.contains(word);
    }

    public static void main(String[] args) {
        Set<String> wordSet = new HashSet<>(Arrays.asList("apple", "banana", "orange", "pear", "peach"));
        String A = "applebananaorange";
        TextSegmentation textSegmentation = new TextSegmentation();
        if (textSegmentation.wordBreak(A, new ArrayList<>(wordSet))) {
            System.out.println("The string can be split into valid words.");
        } else {
            System.out.println("The string cannot be split into valid words.");
        }
    }
}
