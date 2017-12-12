package DP.左大段右小段.linear;
/*
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the intgers in the subsequence are sorted in increasing order.
For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
This problem is a variation of standard Longest Increasing Subsequence (LIS) problem. We need a slight change in the Dynamic Programming solution of LIS problem. All we need to change is to use sum as a criteria instead of length of increasing subsequence.
 */
//Time Complexity: O(n^2)
public class MaximumSumSubsequence {
    public static int longest(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        // Write your solution here.
        int[] dp = new int[array.length];
        // dp[0] = 1;
        int maxSum = array[0];
        for(int i = 0; i < array.length; i++){
            //shortest sequence could start from here
            dp[i] = array[i];
            for(int j = 0; j < i; j++){//induction rule
                if(array[i] > array[j]){
                    //这里dp是取local max
                    dp[i] = Math.max(dp[j] + array[i], dp[i]);
                }
            }
            //这里是global max
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    /* Driver program to test above function */
    public static void main(String args[])
    {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing "+
                " subsequence is "+
                longest( arr) );
    }
}
