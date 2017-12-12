package DP.左大段右小段.linear;
//Input: A = {5, 2, 6, 3, 4, 7, 5}
//        Output: 4
//        Because [2, 3, 4, 5] is the longest ascending subsequence.
//  跳跃式的， 从j 和i的比较可以得出，只要i比j大，那么左大段dp[j] 和 右小段 j和 i =》 + 1
public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        // longest subsequence until i
        int[] dp = new int[array.length];
        // dp[0] = 1;
        int longest = 1;
        for(int i = 0; i < array.length; i++){
            dp[i] = 1;//shortest sequence could start from here
            for(int j = 0; j < i; j++){//induction rule
                if(array[i] > array[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}
