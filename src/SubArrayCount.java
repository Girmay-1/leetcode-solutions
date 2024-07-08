public class SubArrayCount {
    public static int counting(int[] array, int target){
        int sum;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            sum = 0;
            for( int j = i; j < array.length; j++){
                sum += array[j];
                if (sum == target)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(counting(new int[]{1,2,3,4},6));
    }
}
