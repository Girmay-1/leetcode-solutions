package algorithms_and_data_structures.dynamicprogramming;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //create a 2D array to represent min cost of editing
        int[][] memo = new int[m + 1][n + 1];

        //cost of insertion(The edit distance between an empty string and a string of length i is i (insertion))
        for(int i = 0 ; i <= m; i++){
            memo[i][0] = i;
        }
        //cost of deletion(The edit distance between a string of length j and an empty string is j (deletion))
        for(int j = 0; j <= n; j++){
            memo[0][j] = j;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // If the characters at the current positions are equal, no operation is needed
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    memo[i][j] = memo[i - 1][j - 1];
                }else{
                    // Otherwise, choose the minimum of three possible operations:
                    // 1. Insertion (dp[i][j-1])
                    // 2. Deletion (dp[i-1][j])
                    // 3. Substitution (dp[i-1][j-1])
                    memo[i][j] = Math.min(memo[i - 1][j], Math.min(memo[i][j - 1], memo[i - 1][j - 1])) + 1;
                }
            }
        }

        return memo[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String A = "ALGORITHM";
        String B = "ALTRUISTIC";
        System.out.println(editDistance.minDistance(A,B));
    }
}
