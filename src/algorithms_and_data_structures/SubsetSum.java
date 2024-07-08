package algorithms_and_data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 7, 9, 0 , 2, 1)) ;
        int sum = 11;
        System.out.println(subsetSum(arr, sum));
    }

    private static boolean subsetSum(List<Integer> arr, int sum) {
        if (sum == 0)

            return true;
        else if (sum < 0 || arr.isEmpty())
            return false;
        else {
            int len = arr.size();
            int value = arr.remove(len/2);
            boolean withValue = subsetSum(arr, sum - value);
            boolean withoutValue = subsetSum(arr, sum);
            return withValue || withoutValue;
        }
    }
}
