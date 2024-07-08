import java.util.Arrays;

public class SortingArrays {
    public static String sortingArrays(int[] myArray){
        Arrays.sort(myArray);
        return Arrays.toString(myArray);
    }

    public static void main(String[] args) {
        System.out.println(sortingArrays(new int[]{1, 3, 5, 2}));
    }
}
