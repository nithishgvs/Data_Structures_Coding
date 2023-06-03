package org.practice.io.DynamicProgramming;

import org.junit.Test;

public class HouseRobber_198 {

  public int rob(int[] nums) {
    int result = 0;

    if (nums.length == 1) {
      return nums[0];
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[1], dp[0]);

    result = dp[1];

    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
      result = Math.max(result, dp[i]);
    }

    return result;
  }


  @Test
  public void test1() {
    int[] nums = {1, 2, 3, 1};
    int[] nums2 = {2, 1, 1, 2};
    int[] nums3 = {1, 3, 1, 3, 100};
    System.out.println(rob(nums3));
  }

}
