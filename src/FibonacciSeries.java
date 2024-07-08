import java.util.Scanner;
//time compelxity = O(2^n) or exponential
// iterative has linear time complexity.
public class FibonacciSeries {
    public static int fibonacci1(int number) {

        if (number == 1 || number == 2)
            return 1;
        return fibonacci1(number - 1) + fibonacci1(number - 2);

    }

    public static void main(String[] args) {
        System.out.println("enter a number:");
        int number = new Scanner(System.in).nextInt();
            System.out.print(fibonacci1(number) + " ");
        }



}


