package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class HouseRobber_198 {

  /**
   * Checked solution
   */
  public int rob(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }

    return dp[nums.length - 1];
  }


  @Test
  public void test1() {
    System.out.println(rob(new int[]{1, 2, 3, 1}));
  }


  @Test
  public void test2() {
    System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
  }

  @Test
  public void test3() {
    System.out.println(rob(new int[]{6,6,4,8,4,3,3,10}));
  }


  @Test
  public void test4() {
    System.out.println(rob(new int[]{2, 1, 1, 2}));
  }
}
