public class MaxWater {
    public static int maxWater(int[] input){
        int res = 0;
        for(int i = 1; i < input.length -1; i++){
            int left = input[i];
            for(int j = 0; j < i; j++){
                left = Math.max(input[j], left);
            }
            int right = input[i];
            for(int j = i + 1; j < input.length; j++){
                right = Math.max(input[j],right);
            }
            res += Math.min(left, right) - input[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxWater(new int[]{3, 0, 2, 0, 4}));
    }
}
