package algorithms_and_data_structures.sorting;
public class MergeSort {
    /**
     * time taken , O(nlog(n))
     * space = O(n) [this is from the need to create temporary array while merging]
     * @param arr
     * @param start
     * @param end
     */

    public static void main(String[] args) {
        int N = 8;
        int[] arr = {6, 3, 5, 1, 4, 8, 2, 7};

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        mergeSort(arr, 0, N - 1);

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        int mid = (end + start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
       int size1 = mid - start + 1;
        int size2 = end - mid;
        System.out.println("size1:" + size1 + ", size2:" + size2);
        int[] left = new int[size1];
        int[] right = new int[size2];

        for(int i = 0; i < size1; i++){
            left[i] = arr[i + start];
        }

        for( int j = 0; j < size2; j++){
            right[j] = arr[mid + 1 + j];
        }

        int l = 0;
        int r = 0;
        int k = start;

        while (l < size1 && r < size2){
            if (left[l] < right[r])
                arr[k++] = left[l++];
            else
                arr[k++] = right[r++];
        }

        while (l < size1)
            arr[k++] = left[l++];
        while (r < size2)
            arr[k++] = right[r++];




    }
}
