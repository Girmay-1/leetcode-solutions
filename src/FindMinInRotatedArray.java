import java.util.Arrays;

public class FindMinInRotatedArray {
    public static int[] findMin(int[] array, int low, int high) {
        if (high < low)
            return new int[]{array[0],array[high]};
        if (low == high)
            return new int[]{array[low],array[high]};
        int mid = (low + high) / 2;
        if (mid < high && array[mid + 1] < array[mid])
            return new int[]{array[mid + 1],array[mid]};
        if (mid > low && array[mid] < array[mid - 1])
            return new int[]{array[mid],array[mid -1]};
        if (array[mid] < array[high])
            return findMin(array,low, mid);
        return findMin(array,mid + 1, high);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMin(new int[]{4, 5, 1, 2, 3},0, 4)) );
    }
}
