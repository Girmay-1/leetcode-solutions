public class AddFraction {
    public static String addFraction(int num1,int den1, int num2, int den2){
        int den3 = gcf(den1,den2);
        den3 = (den1*den2) / den3; //lcm of den3 and den2
        int num3 = (num1)*(den3/den1) + (num2)*(den3/den2);

        String output = lowest(den3, num3);
        return output;
    }
    static int gcf(int a, int b){
        if (a == 0)
            return b;
        return gcf(b%a, a);
    }
    static String lowest(int den3, int num3){
        int commonFactor = gcf(num3, den3);
        den3 = den3/commonFactor;
        num3 = num3/commonFactor;
        return num3 + "/" + den3;

    }
}
