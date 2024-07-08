public class Armstrong {
    public static boolean isArmstrong(int number){
        int sum = 0;
        //123
        while(number != 0){
            int remainder = number % 10;
            sum = sum + (remainder * remainder * remainder);
            number = number/10;
        }
        if (number == sum)
            return true;
        return false;
    }
}
