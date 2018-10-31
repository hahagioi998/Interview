package DP.左大段右小段.Matrix.SingleString;

public class FindNumberOfBSTGenerated {
    public int numOfTrees(int n) {
        /**
         * Taking 1~n as root respectively:
         *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
         *      2 as root: # of trees = F(1) * F(n-2)
         *      3 as root: # of trees = F(2) * F(n-3)
         *      ...
         *      n-1 as root: # of trees = F(n-2) * F(1)
         *      n as root:   # of trees = F(n-1) * F(0)
         *
         * So, the formulation is:
         *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
         */
        //taking i as root(n), and cut for every i
            int[] dp = new int[n+1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = 0;
                //j <= i because root is included, j -1 because 1 is root, 1 node, then left has 1- 1 = node
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j-1] * dp[i-j];
                }
            }
            return dp[n];
    }
}
