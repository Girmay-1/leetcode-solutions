// from java brains.
public class LongestPalindrome {
    static int palindromeStart;
    static int palindromeLength;

    public static String longestPalindrome(String s){
        if(s.length() < 2){
            return s;
        }
        for (int start = 0; start < s.length(); start++){
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(palindromeStart, palindromeStart + palindromeLength);
    }
    private static void expandRange(String string, int begin, int end){
        while( begin >= 0 && end < string.length() &&
                string.charAt(begin) == string.charAt(end)){
            begin--;
            end++;
        }
        if (palindromeLength < end - begin - 1){
            palindromeLength = end - begin -1;
            palindromeStart = begin + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("hiththelleh"));
    }
}
