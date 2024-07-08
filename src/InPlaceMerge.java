import java.util.Arrays;

public class InPlaceMerge {
    public static void merge(int[] x, int[] y){
        for(int i = 0; i < x.length; i++){
            if(x[i] > y[0]){
                int temp = x[i];
                x[i] = y[0];
                y[0] = temp;
                int first = y[0];
                int k;
                for ( k = 1; k < y.length && first > y[k]; k++){
                    y[k -1] = y[k];
                }
                y[k - 1] = first;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {1,4, 7, 8, 10};
        int[] y = {2,3, 9};
        merge(x,y);
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}
