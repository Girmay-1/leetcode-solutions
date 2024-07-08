package algorithms_and_data_structures.sorting;

import java.util.Arrays;

/**
 * time = O(n ^2)
 */
public class SelectionSort {
    public void selectionSort(int[] nums){
        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
    public static void main(String[] args) {

        int[] arr = {-2, -9, 42, 21, 66, 7, 8, 1, 0, 2};
        System.out.println(Arrays.toString(arr));
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
