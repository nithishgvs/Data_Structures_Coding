package org.leetcode.Arrays;

import org.junit.Test;

public class MinimumSizeSubarraySum_209 {

  public int minSubArrayLen(int s, int[] nums) {

    int minSize = Integer.MAX_VALUE;

    int start = 0, end = 0;
    int sum = 0;
    while (end < nums.length) {
      sum += nums[end];
      end++;
      while (sum >= s && start <= end) {
        if (end - start < minSize) {
          minSize = end - start;
        }
        sum = sum - nums[start];
        start++;
      }

    }

    return minSize == Integer.MAX_VALUE ? 0 : minSize;

  }


  @Test
  public void test1() {
    System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
  }


  @Test
  public void test2() {
    System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
  }

}
