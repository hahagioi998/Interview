package DP.左大段右小段.linear;
/*
Optimal Substructure:
Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
Then, L(i) can be recursively written as:
L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
L(i) = 1, if no such j exists.
To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be solved using solutions to subproblems.
 */
public class LongestIncreasingSubsequence {
    public int longest(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        // Write your solution here.
        int[] dp = new int[array.length];
        // dp[0] = 1;
        int longest = 1;

        for(int i = 0; i < array.length; i++){
            dp[i] = 1;//shortest sequence could start from here
            for(int j = 0; j < i; j++){//induction rule
                if(array[i] > array[j]){
                    //这里dp是取local max
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            //这里是global max
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}
