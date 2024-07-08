
// reference: https://github.com/cherryljr/LeetCode/blob/master/Minimum%20Size%20Subarray%20Sum.java
public class MinLengthSubArray {
    public static int minLengthSubArray(int target, int[] array){
        if(array.length ==0 || array == null)
            return 0;
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int right = 0; right < array.length; right++){
            sum += array[right];
            while (sum >= target){
                result = Math.min(result, right - left + 1);
                sum -= array[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(minLengthSubArray(6, new int[]{1,2,3,4}));

    }
}
