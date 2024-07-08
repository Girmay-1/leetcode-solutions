package algorithms_and_data_structures.sorting;

import java.util.Arrays;

/**
 * time = best case : O(nlogn) worst case O(n ^2)
 * space = best case : O(logn) due to recursive calls which becomes O(n) in the worst case scenario
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {-2, -9, 42, 21, 66, 7, 8, 1, 0, 2};


        System.out.println(Arrays.toString(arr));
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void quicksort(int[] arr, int low, int high) {
        if(high > low){
            int pivot = partition(low, high, arr);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }
    private int partition(int low, int high, int[] arr){
        int pivot = arr[high];
        int  i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
