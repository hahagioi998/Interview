package DP.左大段右小段.NonEqualWeight;
/*
Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
Time complexity of the above solution is O(mV).
Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents
This problem is a variation of the problem discussed Coin Change Problem.
Here instead of finding total number of possible solutions, we need to find the solution with minimum number of coins.

The minimum number of coins for a value V can be computed using below recursive formula.

If V == 0, then 0 coins required.
If V > 0
   minCoin(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])}
                               where i varies from 0 to m-1
                               and coin[i] <= V
 */
public class CoinChangeII {
    int coinChange(int[] coins, int amount) {
        int Max = amount + 1;
        int[] dp = new int[coins.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //对于每一个amount，都要试试看要不要用这个面值
            for (int j = 0; j < coins.length; j++) {
                //这里要检查coins是不是小于
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
