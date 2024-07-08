package algorithms_and_data_structures.dynamicprogramming;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
 * substrings
 *  respectively, such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 */
public class InterlievingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int m = s1.length();
        int n = s2.length();

        boolean[][] memo = new boolean[m + 1][n + 1];
        //base case
        memo[0][0] = true;

        for(int i = 1; i <= m; i++){
            memo[i][0] = memo[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for(int j = 1; j <= n; j++){
            memo[0][j] = memo[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                memo[i][j] = (memo[ i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (memo[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(memo[i][j] + " ");
//            }
//            System.out.println(); // Move to the next line after printing each row
//        }
        return  memo[m][n];

    }

    /**
     * imporoved space complexity:
     * @param args
     */
    public boolean isInterleave2(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for(int j = 1; j <= n; j++){
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for(int i = 1; i <= m; i++){
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                        dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n];
    }

    public boolean isInterleave3(String s1, String s2, String s3){
        // Check if the lengths of s1, s2, and s3 match
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // Create a 1D DP array to store the intermediate results
        boolean[] dp = new boolean[s1.length() + 1];

        // Initialize the DP array
        dp[0] = true;

        // Check if s1 matches s3
        for (int i = 1; i <= s1.length(); i++) {
            dp[i] = dp[i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Check if interleaving of s1 and s2 matches s3
        for (int j = 1; j <= s2.length(); j++) {
            dp[0] = dp[0] && s2.charAt(j - 1) == s3.charAt(j - 1);
            for (int i = 1; i <= s1.length(); i++) {
                dp[i] = (dp[i] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i - 1] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }

        // Return the result from the last element of the DP array
        return dp[s1.length()];
    }

    public static void main(String[] args) {
        InterlievingString solution = new InterlievingString();
        // Test cases
        String s1 = "axbvc";
        String s2 = "dbbca";
        String s3 = "axbvcdbbca";
        System.out.println("Is '" + s3 + "' an interleaving of '" + s1 + "' and '" + s2 + "'? " + solution.isInterleave(s1, s2, s3));
        System.out.println("Is '" + s3 + "' an interleaving of '" + s1 + "' and '" + s2 + "'? " + solution.isInterleave2(   s1, s2, s3));
        System.out.println("Is '" + s3 + "' an interleaving of '" + s1 + "' and '" + s2 + "'? " + solution.isInterleave3(   s1, s2, s3));

    }
}
