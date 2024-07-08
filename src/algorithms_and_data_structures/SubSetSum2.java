package algorithms_and_data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubSetSum2 {
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>(Arrays.asList(3, 7, 4, 8, 9 , 6));
        int sum = 11;
        ArrayList<Integer> result = subSetSum2(arr, arr.size() - 1, sum);
        System.out.println(result);
    }

    private static ArrayList<Integer> subSetSum2(List<Integer> arr, int i, int sum) {
        if (sum == 0)
            return  new ArrayList<>();
        else if (sum < 0 ||  i <= 0)
            return null;
        else {

            ArrayList<Integer> z = subSetSum2(arr, i - 1, sum);
            if (z != null)
                return z;
            z = subSetSum2(arr, i - 1, sum - arr.get(i));
            if (z != null){
                z.add(arr.get(i));
                return z;
            }
        }
        return null;
    }
}
