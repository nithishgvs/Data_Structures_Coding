package org.lcfresh.practice;

import org.junit.Test;

public class HouseRobber_198 {

  public int rob(int[] nums) {
    int result = 0;
    int dp[] = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int newValue = 0;
      if (i - 2 > -1) {
        newValue = Math.max(result, nums[i] + dp[i - 2]);
      } else {
        newValue = Math.max(result, nums[i]);
      }
      dp[i] = newValue;
      result = Math.max(dp[i], result);
    }
    return result;
  }


  @Test
  public void test1() {
    int[] nums = {2, 7, 9, 3, 1};
    System.out.println(rob(nums));
  }

  @Test
  public void test2() {
    int[] nums = {2, 4, 8, 9, 9, 3};
    System.out.println(rob(nums));
  }
}
