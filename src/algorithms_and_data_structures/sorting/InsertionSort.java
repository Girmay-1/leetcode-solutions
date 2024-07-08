package algorithms_and_data_structures.sorting;
/**
 * time: O(n^2).
 */

import java.util.Arrays;

public class InsertionSort {
    public void insertionSort(int[] nums){
        int n = nums.length;
        for(int i = 1; i < n ; i++){
            int key = nums[i];
            int j = i - 1;

            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }
    public static void main(String[] args) {

        int[] arr = {-2, -9, 42, 21, 66, 7, 8, 1, 0, 2};
        System.out.println(Arrays.toString(arr));
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
