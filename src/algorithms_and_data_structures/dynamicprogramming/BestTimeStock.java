package algorithms_and_data_structures.dynamicprogramming;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 */
public class BestTimeStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null){
            return 0;
        }

        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;

        for(int i = 1; i < prices.length; i++){
            buy1 = Math.max(buy1, -prices[i]);     //maximum profit after first buy
            sell1 = Math.max(sell1, buy1 + prices[i]); //maximum profit after first sell
            buy2 = Math.max(buy2, sell1 - prices[i]); //maximum profit after second buy
            sell2 = Math.max(sell2, prices[i] + buy2); //maximum profit after second sell.
        }
        return sell2;
    }

    public static void main(String[] args){
        BestTimeStock bestTimeStock = new BestTimeStock();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(bestTimeStock.maxProfit(prices));
    }
}
