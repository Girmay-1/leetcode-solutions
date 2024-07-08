package algorithms_and_data_structures.dynamicprogramming;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 */
public class LongestPalindrome {
    /**
     * solution one brute - force (expand around center approach)
     *
     * time: o( n ^2) and space : O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        if(s== null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++){
            int len1 = expandInCenter(s, i, i); //if len is odd
            int len2 = expandInCenter(s, i, i + 1); //if len is even

            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len - 1) / 2; //because when len is even, "i" is pointing on the left middle. Hence, we subtract a lesser value to reach the start. if odd, doesn't make a difference.
                end = i + len / 2;

            }
        }
        return s.substring(start, end + 1);
    }

    private int expandInCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1; //because right points to the position immediately after the last character of the palindrome, and left points to the position immediately before the first character of the palindrome.
    }

    /**
     * solution 2, dynamic programming (improved time still n ^2 but efficient. Space increases to n ^ 2
     * @param s
     *
     * @return string
     */
    public String longestPalindrome2(String s){
        if(s== null || s.length() == 0){
            return "";
        }

        // create a 2D array to store the palindrome
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxLength = 1;
        int start = 0;
        //a character is equal to itself so set isPalindrome to true when i == i (length 1);
        for(int i = 0; i < s.length(); i++){
            isPalindrome[i][i] = true;
        }



        //check for remaining lengths; (if 2 just check the chars are equal if above 2, check if chars in between are equal)
        for(int len = 2; len <= s.length(); len++){
            for(int i = 0 ; i <= s.length() - len; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && (len == 2 || isPalindrome[i + 1][j - 1])){
                    isPalindrome[i][j] = true;
                    if(len > maxLength){
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }


        return s.substring(start, start + maxLength);

    }


    public static void main(String[] args) {
        String s = "HOWDOOOD";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(s));
        System.out.println(longestPalindrome.longestPalindrome2(s));
    }
}
