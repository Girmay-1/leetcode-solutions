package algorithms_and_data_structures;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSelect {
    public static void main(String[] args){
         List<Integer> arr=  Arrays.asList(3,4, 7, 5,-3,2);
         int k = 1;
         int value = quickSelect(arr, k - 1);
         System.out.println(value);
    }

    private static int quickSelect(List<Integer> arr, int k) {
        if (arr.size() == 1){
            return arr.get(0);
        }
        int p = arr.size()/2;
        int r = partition(arr, p);
        if ( k < r){
            return quickSelect(arr.subList(0,r), k);
        }
        else if ( k > r){
            return  quickSelect(arr.subList(r + 1, arr.size() - 1), k - r - 1);
        }
        else {
            return arr.get(r);
        }
    }

    private static int partition(List<Integer> arr, int p) {
        int pivot = arr.get(p);
        Collections.swap(arr, p, arr.size() - 1);
        int l = -1;
        for ( int i = 0; i < arr.size(); i++){
            if (arr.get(i) < pivot){
                l++;
                Collections.swap(arr,i, l);
            }
        }
        Collections.swap(arr, l + 1, arr.size() - 1);
        return l + 1;
    }
}
