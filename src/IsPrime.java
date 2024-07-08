public class IsPrime {
    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

        // using recursion
        public static boolean isPrimeRec(int number, int i){
        if (number == 2)
            return true;
        if (number < 2)
            return false;
        if (number % i == 0)
            return false;
        if ( i * i > number)
            return true;
        return isPrimeRec(number, i + 1);

        }


    public static void main(String[] args) {
        System.out.println(isPrime(112));
        System.out.println(isPrimeRec(7,2));
    }
}
