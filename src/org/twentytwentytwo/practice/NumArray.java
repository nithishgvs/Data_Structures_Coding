package org.twentytwentytwo.practice;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class NumArray {

  int[] dp;

  public NumArray(int[] nums) {
    dp = new int[nums.length];
    dp[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dp[i] = nums[i] + dp[i - 1];
    }

  }

  public int sumRange(int left, int right) {
    if (left == 0) {
      return dp[right];
    }
    return dp[right] - dp[left - 1];
  }


  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    NumArray numArray = new NumArray(nums);
    System.out.println(numArray.sumRange(0, 5));
  }
}
