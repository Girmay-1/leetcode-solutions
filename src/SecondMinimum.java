public class SecondMinimum {
    public static int secondMinimum(int[] array){
       int min, secondMin;
       min = secondMin = Integer.MAX_VALUE;
       for(int i = 0; i < array.length; i++){
           if(min == array[i]){
               secondMin = min;
           }
           else if(array[i] < min){
               secondMin = min;
               min = array[i];
           }
           else if (array[i] < secondMin)
               secondMin = array[i];
       }
       return secondMin;
    }

    public static void main(String[] args) {
        System.out.println(secondMinimum(new int[]{1, 4, 2, 7}));
    }
}
