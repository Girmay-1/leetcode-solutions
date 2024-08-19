package algorithms_and_data_structures.sorting;

public class MergeSort2 {
    public int[] mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return new int[]{nums[start]};
        }
        int mid = (start + end) / 2;
        int[] left = mergeSort(nums, start, mid);
        int[] right = mergeSort(nums, mid + 1, end);


        return merge(left, right, nums);
    }
    private int[] merge(int[] left, int[] right, int[] nums){
        int l = 0, r = 0, k = 0;
        int[] result = new int[left.length + right.length];
        while(l < left.length && r < right.length){
            if(left[l] < right[r]){
                result[k++] = left[l++];
            }else{
                result[k++] = right[r++];
            }
        }
        while(l < left.length){
            result[k++] = left[l++];
        }while(r < left.length){
            result[k++] = right[r++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 1, 4, 8, 2, 7};
        int N = arr.length;
        MergeSort2 sol = new MergeSort2();
        int[] solut =  sol.mergeSort(arr, 0, N - 1);

        for (int i = 0; i < N; i++) {
            System.out.print(solut[i] + " ");
        }
    }
}