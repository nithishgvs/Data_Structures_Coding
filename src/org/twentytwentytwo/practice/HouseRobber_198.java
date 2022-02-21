package org.twentytwentytwo.practice;

import org.junit.Test;

public class HouseRobber_198 {

  public int rob(int[] nums) {

    int[] dp = new int[nums.length];

    dp[0] = nums[0];
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (i - 2 > -1) {
        dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
      } else {
        dp[i] = Math.max(nums[i], dp[i - 1]);
      }
      max = Math.max(dp[i], max);
    }

    return max;

  }


  @Test
  public void test() {
    int[] nums = {2};
    System.out.println(rob(nums));
  }
}
