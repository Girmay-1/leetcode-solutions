package algorithms_and_data_structures.dynamicprogramming;

/**
 * Given a string s, return the number of different non-empty palindromic subsequences in s. Since the answer may be very large, return it modulo 109 + 7.
 *
 * A subsequence of a string is obtained by deleting zero or more characters from the string.
 *
 * A sequence is palindromic if it is equal to the sequence reversed.
 *
 * Two sequences a1, a2, ... and b1, b2, ... are different if there is some i for which ai != bi.
 */
public class CountPalindromicSubSequence {
    private static int MOD = 1_000_000_007;
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        long[][] dp = new long[n][n];

        //initialize dp for length 1
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }


        //calculate for different lengths;

        for(int len = 2; len <= n; len++){
            for(int i = 0; i < n - len + 1; i++){ //starting index
                int j = i + len - 1; //ending endex

                if(s.charAt(i) == s.charAt(j)){
                    int left = i + 1;
                    int right = j - 1;
                    while(left <= right && s.charAt(i) != s.charAt(left)) left++;
                    while(left <= right && s.charAt(i) != s.charAt(right)) right--;

                    //1.All chars in between i & j are not equal to chart at i/j
                    if(left > right){
                        //aba: aba [ a b aa aba]

                        dp[i][j] = dp[i + 1][j -1] * 2 + 2;
                    }
                    //2. There is exactly one character the same as char at i/j
                    //xaxax: a aa aba xax xbx xaax xabax x xx
                    else if(left == right){
                        dp[i][j] = dp[i + 1][j -1] * 2 + 1;
                    }
                    //3. There are more than one character same as char at i/j
                    else{
                        dp[i][j] = dp[i + 1][j -1] * 2 - dp[left + 1][right - 1];
                    }
                }else{
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }

                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }

        return (int)dp[0][n - 1];
    }
    public static void main(String[] args) {
        CountPalindromicSubSequence cps = new CountPalindromicSubSequence();

        // Test case 1
        String s1 = "bccb";
        System.out.println("Count of palindromic subsequences in '" + s1 + "': " + cps.countPalindromicSubsequences(s1));

        // Test case 2
        String s2 = "aaaa";
        System.out.println("Count of palindromic subsequences in '" + s2 + "': " + cps.countPalindromicSubsequences(s2));

        // Test case 3
        String s3 = "ababa";
        System.out.println("Count of palindromic subsequences in '" + s3 + "': " + cps.countPalindromicSubsequences(s3));
    }
}
