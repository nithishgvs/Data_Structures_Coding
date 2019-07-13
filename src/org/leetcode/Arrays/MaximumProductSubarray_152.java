package org.leetcode.Arrays;

import org.junit.Test;

public class MaximumProductSubarray_152 {

  public int maxProduct(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int max = nums[0];
    int[] dpMax = new int[nums.length];
    int[] dpMin = new int[nums.length];
    dpMin[0] = nums[0];
    dpMax[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dpMax[i] = Math.max(Math.max(nums[i], nums[i] * dpMax[i - 1]), nums[i] * dpMin[i - 1]);
      dpMin[i] = Math.min(Math.min(nums[i], nums[i] * dpMin[i - 1]), nums[i] * dpMax[i - 1]);
      max = Math.max(max, dpMax[i]);
    }

    return max;

  }

  @Test
  public void test1() {
    System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
  }

  @Test
  public void test2() {
    System.out.println(maxProduct(new int[]{2,-1,1,1}));
  }

  @Test
  public void test3() {
    System.out.println(maxProduct(new int[]{0, 2}));
  }


  @Test
  public void test4() {
    System.out.println(maxProduct(new int[]{-2, 3, -4}));
  }

}
