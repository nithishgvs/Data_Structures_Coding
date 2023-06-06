package org.practice.io.DynamicProgramming;

import java.util.Arrays;
import org.junit.Test;

public class HouseRobberII_213 {


  public int rob(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(returnMax(Arrays.copyOfRange(nums, 0, nums.length - 1)),
        returnMax(Arrays.copyOfRange(nums, 1, nums.length)));

  }


  private int returnMax(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    int result;

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
    int[] nums3 = {200, 3, 140, 20, 10};
    int[] nums1 = {0, 0};
    int[] nums2 = {1, 2};
    System.out.println(rob(nums2));
  }

}
