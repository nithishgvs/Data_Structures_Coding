package org.twentytwentytwo.practice;

import org.junit.Test;

public class MaximumSubarray_53 {


  public int maxSubArray(int[] nums) {

    int maxNow = nums[0];
    int mainMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxNow = Math.max(nums[i] + maxNow, nums[i]);
      mainMax = Math.max(mainMax, maxNow);
    }

    return mainMax;
  }


  @Test
  public void test() {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }
}
