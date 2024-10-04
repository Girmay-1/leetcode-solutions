package General;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int U, int[] weights) {
        //turned back car can be the current car or the car after the current car.
        int[] dp = new int[weights.length];
        for(int i = weights.length - 1; i >= 0; i--){
            int currentCarWeight = weights[i];
            int option1 = 1 + (i + 1 < (weights.length - 1)? dp[i + 1]: 0); //current car turns back;
            int returnedCarsAtAllowedCar = 0;
            int turnedBackCount = 0;
            for(int j = i + 1; j < weights.length; j++){
                if(currentCarWeight + weights[j] <= U){
                    returnedCarsAtAllowedCar = dp[j];
                    break;
                }else{
                    turnedBackCount++;

                }
            }

            int option2 = returnedCarsAtAllowedCar + turnedBackCount;

            dp[i] = Math.min(option2, option1);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int U1 = 9;
        int[] weight1 = {5, 3, 8, 1, 8, 7, 7, 6};
        System.out.println(sol.solution(U1, weight1)); // Output: 4

        int U2 = 7;
        int[] weight2 = {7, 6, 5, 2, 7, 4, 5, 4};
        System.out.println(sol.solution(U2, weight2)); // Output: 5

        int U3 = 7;
        int[] weight3 = {3, 4, 3, 1};
        System.out.println(sol.solution(U3, weight3)); // Output: 0
    }

}
