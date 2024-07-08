package algorithms_and_data_structures.dynamicprogramming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //initialize a memo
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        //base case:
        memo[0] = 0;

        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }

        return memo[amount] > amount? -1 : memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        CoinChange coinChange  = new CoinChange();
        System.out.println("coins needed: "+  coinChange.coinChange(coins,amount));
    }
}
