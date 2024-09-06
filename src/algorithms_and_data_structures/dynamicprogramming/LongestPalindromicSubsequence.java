package algorithms_and_data_structures.dynamicprogramming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        //initialize dp;
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int len = 2; len <= n; len++){
            for(int i = 0; i < n - len + 1; i++){ //strating index
                int j = i + len - 1; //ending index;

                if(s.charAt(i) == s.charAt(j) && len == 2){
                    dp[i][j] = 2;
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }


        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();

        // Test case 1
        String s1 = "bbbab";
        System.out.println("Input: " + s1);
        System.out.println("Longest Palindromic Subsequence: " + solution.longestPalindromeSubseq(s1));
        System.out.println();

        // Test case 2
        String s2 = "cbbd";
        System.out.println("Input: " + s2);
        System.out.println("Longest Palindromic Subsequence: " + solution.longestPalindromeSubseq(s2));
        System.out.println();

        // Test case 3
        String s3 = "aabaa";
        System.out.println("Input: " + s3);
        System.out.println("Longest Palindromic Subsequence: " + solution.longestPalindromeSubseq(s3));
    }
}
