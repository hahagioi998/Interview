package DP.左大段右小段.linear;
/*
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Assumptions

n >= 2
Examples

n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
 */
public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // left part is undivisible j
        //right part is divisible, choose between what you can get from i and j or a previous state
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;//can't cut
        dp[2] = 1;
        for (int i = 0; i <= length; i++) {//<=
            for (int j = 0; j <= i/2; j++) {//<=  two parts (0 to j) j and j to i
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[length];
    }
}
