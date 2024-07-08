package algorithms_and_data_structures.stringsandarrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] sol = new int[nums.length];

        // 1) compute left side product.
        sol[0] = 1;
        for(int i = 1; i < nums.length; i++){
            sol[i] = sol[i - 1] * nums[i - 1];
        }
        //2. compute right side product
        //3. compute left * right: which is the solution
        int rightProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            sol[i] = sol[i + 1] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ProductExceptItself solution = new ProductExceptItself();
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));

    }
}
