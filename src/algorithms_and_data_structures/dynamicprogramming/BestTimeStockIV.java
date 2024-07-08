package algorithms_and_data_structures.dynamicprogramming;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeStockIV {
    public int maxProfit(int k, int[] prices) {
        //check the edge cases;
        if(prices == null || prices.length == 0){
            return 0;
        }
        //if k is large enough (if we can do transaction each day), profit is simply the positive difference of each day's prices.
        if(k  >= prices.length/2){
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        //use dynamic programming
        //create a 2D array to store the profits of each transaction for each day.
        int[][] profit = new int[k + 1][prices.length];

        for(int i = 1; i <= k; i++){
            int initialTransaction = -prices[0];
            for(int j = 1; j < prices.length; j++){
                // Calculate the maximum profit either by not transacting on the current day
                // or by buying on a previous day and selling on the current day
                profit[i][j] = Math.max(profit[i][j - 1], initialTransaction + prices[j]);
                // Update initialTransaction to track the maximum difference between prices[j] and dp[i - 1][j]
                initialTransaction = Math.max(initialTransaction, profit[i -1][j] - prices[j]);
            }
        }

        return profit[k][prices.length - 1];
    }

    public static void main(String[] args) {
        BestTimeStockIV sol = new BestTimeStockIV();
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(sol.maxProfit(k, prices)); // Output: 7
    }
}
