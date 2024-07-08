public class DivideFraction {
    public static String divideFraction(int[] arr1, int[] arr2){
        int num1= arr1[0];
        int den1 = arr1[1];
        int num2= arr1[0];
        int den2 = arr1[1];
        int num3 = num1 * den2;
        int den3 = den1 * num2;
        String result = lowest(num3, den3);
        return result;
    }
    static int gcf(int a, int b){
        if (a == 0)
            return b;
        return gcf(b%a,a);
    }
    static String lowest(int num3, int den3){
        int commonFactor = gcf(num3,den3);
        num3 = num3/commonFactor;
        den3 = den3/commonFactor;
        return num3 + "/" + den3;
    }
}
