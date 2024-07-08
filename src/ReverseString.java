// this is for reversing string and checking palindrome using string builder.
public class ReverseString {
    public static boolean isPalindrome(String s){
        if(s == null)
            throw new IllegalArgumentException("input should not be null");
        String string = new StringBuilder(s).reverse().toString();
        if(s.equals(string))
            return true;
        return false;

    }
    // or alternatively we can convert string to charArray and append to reverse it.
    public static String reverseString(String s){
        if (s == null)
            throw new IllegalArgumentException("input shouldn't be null");
        StringBuilder out = new StringBuilder();
        char[] tochar =s.toCharArray();
        for (int i = s.length() - 1; i >=0; i--)
            out.append(tochar[i]);
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseString.isPalindrome("yoo"));
        System.out.println(ReverseString.reverseString("hello"));
    }
}
