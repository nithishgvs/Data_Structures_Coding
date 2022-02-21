package org.twentytwentytwo.practice;

import org.junit.Test;

public class TargetSum_494 {

  int count = 0;

  public int findTargetSumWays(int[] nums, int target) {

    targetSumHelper(nums, target, 0, nums.length - 1, 0);
    return count;
  }

  private void targetSumHelper(int[] nums, int target, int l, int h, int currentSum) {
    if (l > h) {
      return;
    }

    int tempSum = currentSum + nums[l];
    int high = l + 1;
    if (tempSum == target && high == nums.length) {
      count++;
    }
    targetSumHelper(nums, target, high, h, tempSum);
    tempSum = currentSum - nums[l];
    if (tempSum == target && high == nums.length) {
      count++;
    }
    targetSumHelper(nums, target, high, h, tempSum);
  }

  @Test
  public void test() {
    int[] nums = {1};
    System.out.println(findTargetSumWays(nums, 1));
  }
}
