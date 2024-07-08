import java.util.Arrays;

public class SegregateArray {
    public static int[] segregateArray(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            while(array[left] % 2 == 0 && left < right)
                left++;
            while(array[right] % 2 == 1 && left < right)
                right--;
            if(left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(segregateArray(new int[]{1, 3, 2, 4, 6})));
    }
}
