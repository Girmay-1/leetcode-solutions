public class SumFibo {
    public static int fibonacci1(int number) {

        if (number == 1 || number == 2)
            return 1;
        return fibonacci1(number - 1) + fibonacci1(number - 2);

    }
    public static int sum(int input){
        int i =0;
        int sum = 0;
        while( fibonacci1(i) < input){
            sum = sum + fibonacci1(i);
        }
        return sum;
    }
}
