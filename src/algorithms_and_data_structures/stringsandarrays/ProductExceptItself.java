package algorithms_and_data_structures.stringsandarrays;

public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int product = 1;
        for(int i = 0; i < len; i++){
            answer[i] = product;

            product *= nums[i];
        }

        product = 1;
        for(int i = len - 1; i >= 0; i--){
            answer[i] *= product;
            product *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ProductExceptItself sol = new ProductExceptItself();
        int [] arr = sol.productExceptSelf(new int[]{1,2,3,4});
        sol.printArray(arr);
    }
    private void printArray(int[] arr){
        System.out.print( "[");
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.print( "]");
    }
}
