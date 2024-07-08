public class IsIntegerPalindrom {
    public static boolean isPalindrome(int x){
        if(x < 0 || (x %10 == 0 && x != 0)){
            return false;
        }
        int reversedNumber = 0;
        while(x > reversedNumber){
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }
        //also account for when the digits are even
        return (reversedNumber == x || x == reversedNumber/10 );
    }

    // time: O(log_10(n)) (since each interation will effectively divide x by 10)
    // space : O(1)



}
