package algorithms_and_data_structures.math;

/**
 * calculate pow(x, n) without using built in fucntions.
 */
public class Power {
//space = O(1)
//time = O(logn)
    public double myPow(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1/x;
        }

        double pow = 1;
        while(n != 0){
            if((n & 1) != 0){  //equivalent to n %2 != 0
                pow *= x;
            }

            x *= x;
            n >>>= 1;  //equivalent to n/2
        }

        return pow;
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.myPow(5,3));

    }
}
