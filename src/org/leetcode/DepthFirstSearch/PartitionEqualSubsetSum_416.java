package org.leetcode.DepthFirstSearch;

import org.junit.Test;

public class PartitionEqualSubsetSum_416 {


  public boolean canPartition(int[] nums) {

    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if (sum % 2 != 0) {
      return false;
    }

    return helper(nums.length - 1, nums, 0, sum / 2);

  }

  public boolean helper(int i, int[] nums, int sum, int target) {

    if (sum == target) {
      return true;
    }

    if (i < 0 || nums[i] > target || sum > target) {
      return false;
    }

    return helper(i - 1, nums, sum + nums[i], target) || helper(i - 1, nums, sum, target);

  }


  @Test
  public void test1() {
    System.out.println(canPartition(new int[]{1, 2, 3, 4}));
  }

  @Test
  public void test2() {
    System.out.println(canPartition(new int[]{1, 5, 11, 5}));
  }
}
