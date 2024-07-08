public class IsPowerOf10 {
    public static boolean checkPowerOf10(int n)
    {

        double i = Math.log(n)/Math.log(10);
        System.out.println(i);

        return i - Math.floor(i) < 0.00001;
    }

    public static void main(String[] args) {
        System.out.println(checkPowerOf10(100));
    }
}
