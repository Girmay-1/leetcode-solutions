public class IsPalindrome {
    static boolean isPalindrome(String s) {

        int j = s.length() - 1;
//        int i =0;
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j))
//                return false;
//            i++;
//            j--;
//
//        }
        for( int i = 0; i < j ; i++) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("HelleH"));
    }
}
