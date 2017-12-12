package DP.左大段右小段.NonEqualWeight;

import java.util.Arrays;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

 1) Optimal Substructure
To count total number solutions, we can divide all set solutions in two sets.
1) Solutions that do not contain mth coin (or Sm).
2) Solutions that contain at least one Sm.
Let count(S[], m, n) be the function to count the number of solutions, then it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm).

Therefore, the problem has optimal substructure property as the problem can be solved using solutions to subproblems.
 */
public class CoinChange {
    static long countWays(int[] coins, int m, int amount)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i ！ We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[amount + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 1; i <= amount; i++)
            // coins[j]是硬币的值，对每一个面值，算大于这个面值的所有钱数和这个面值的组合方法
            //对每一个面额做左大段和右小段的切分，右小段就是不可再分的面值,table里存的就是每一个面额的切分方法
            //table[4]= table[3] + 1   只有一种切分方法
            //table [4] = table[1] + 3  一种切分方法
            //table[4] = table[2] + 2   两种切分方法
            //table[3] = table[2] + 1
            //table[3] = table[1] + 2
            //table[3] = table[0] + 3
            //table[2] = 1 + table[1]  2 ways
            //table[2] = 2 + table[0]
            //table[1] = 1 + table[0]
            //所以当面值为1的时候，table[j]就加上所有 1 + table[j - 1]
            for (int j = 0; j < coins.length; j ++)
                //j-S[i]是 Solutions that contain at least one Sm
                if(coins[j] <= i)
                table[i] += table[i - coins[j]];
/*
        for (int i=0; i < coin.length; i++) //面值
            for (int j=coins[i]; j<= amount; j++)
                table[j] += table[j-coins[i]];
*/
        return table[amount];
    }

    // Driver Function to test above function
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(countWays(arr, m, n));
    }
}
