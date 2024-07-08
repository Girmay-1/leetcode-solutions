/**
 * Given an integer array queries and a positive integer intLength, return an array answer where answer[i] is either the queries[i]th smallest positive palindrome of length intLength or -1 if no such palindrome exists.
 *
 * A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.
 *
 *
 */
public class isKthPalindrome {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] sol = new long[queries.length];
        int index = 0;
        int halfLength = (intLength + 1)/ 2;

        long minPalindrome = (long) Math.pow(10, halfLength - 1) - 1;
        long maxPalindrome = (long) Math.pow(10, halfLength ) - 1;

        for(int query : queries){
            if(query <= maxPalindrome - minPalindrome){
                String rightHalf = Long.toString(query + minPalindrome);
                String lefHalf = (new StringBuilder(rightHalf).reverse()).toString();
                sol[index] = Long.parseLong(rightHalf + lefHalf.substring(intLength % 2));
            }else{
                sol[index] = -1;
            }
            index++;
        }
        return sol;
    }

    // time : O(n * intLength)
    // space : O(n)

}
