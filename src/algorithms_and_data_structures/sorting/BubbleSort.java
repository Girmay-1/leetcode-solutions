package algorithms_and_data_structures.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * bubble sort O(n^2)
 * space : o(1)
 */
public class BubbleSort {
    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(2, -4, 7, 0, -1, 1);
        bubbleSort(arr);
        for (Integer integer : arr) System.out.print("[" + integer + "]");
    }

    private static void bubbleSort(List<Integer> arr) {
        for(int i = 0; i < arr.size(); i ++){
            for(int j = 0; j < arr.size() - i - 1; j++){
                if(arr.get(j)> arr.get(j + 1)){
                    Collections.swap(arr,j, j + 1);
                }
            }
        }
    }
}
