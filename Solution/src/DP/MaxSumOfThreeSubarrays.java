package DP;

import DP.中心开花.EggDropping;

/*
In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest
 */

//Follow up question：如果要求n个而不是三个，应该如何解决？

public class MaxSumOfThreeSubarrays {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int[] result = new int[3];
    if(nums == null || nums.length == 0) {
      return result;
    }

    int length = nums.length;
    int[] sum = new int[length];

    // k prefix
    sum[0] = nums[0];
    for (int i = 1; i < length; i++) {
      sum[i] = sum[i - 1] + nums[i];
      if (i >= k) {
        sum[i] -= nums[i - k];
      }
    }

    // left max end index 到i为止,左边最大的index
    int[] left = new int[length];
    int leftMaxIndex = k - 1;
    for (int i = k - 1; i < length; i++) {
      left[i] = sum[i] > sum[leftMaxIndex] ? i : leftMaxIndex;
      leftMaxIndex = left[i];
    }

    // right max end index
    int[] right = new int[length];
    int rightMaxIndex = length - 1;
    for (int i = length - 1; i >= k - 1; i--) {
      right[i] = sum[i] >= sum[rightMaxIndex] ? i : rightMaxIndex;
      rightMaxIndex = right[i];
    }

    int max = Integer.MIN_VALUE;
    // scan i的左边和右边
    for (int i = 2 * k - 1; i < length - k; i++) {
      int sum3 = sum[left[i - k]] + sum[i] + sum[right[i + k]];
      if (sum3 > max) {
        max = sum3;
        // -k + 1是为了获取starting index
        result[0] = left[i - k] - k + 1;
        result[1] = i - k + 1;
        result[2] = right[i + k] -k + 1;
      }
    }

    return result;
  }

  public static void main(String args[]){
    MaxSumOfThreeSubarrays sol = new MaxSumOfThreeSubarrays();
    int[] nums = new int[]{1,2,1,2,6,7,5,1};
    int k = 2;
    int[] res = new int[]{3*k};
    res = sol.maxSumOfThreeSubarrays(nums,k);
    System.out.println(res);
  }
}
