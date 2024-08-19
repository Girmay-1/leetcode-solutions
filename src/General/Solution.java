package General;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int U, int[] weights) {
        int[] dp = new int[weights.length];

        for (int i = weights.length -1; i >= 0; i--) { //traverse back and count with or without current car and take min
            // option1 - with current car
            int currentWeightOnBridge = weights[i]; // weight on the bridge now
            int turnBackCount = 0; //count how may cars to turn back to reach the next car that is allowed on the bridge with the current car
            int turnBackCountAtAllowedCar = 0; //turn back count at the allowed car (previously computed already, can be found in dp array)
            for (int j = i + 1; j <= weights.length -1; j++){
                if(currentWeightOnBridge + weights[j] <= U){//allowed found
                    turnBackCountAtAllowedCar = dp[j];
                    break;
                } else {//turn back
                    turnBackCount++;
                }
            }
            int option1 = turnBackCount + turnBackCountAtAllowedCar;

            // option2 - without current car - dp of next cell (on right hand side - previously processed) if exists
            int option2 = 1 + ((i + 1 <= weights.length -1) ? dp[i+1] : 0);

            dp[i] = Math.min(option1, option2);
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
