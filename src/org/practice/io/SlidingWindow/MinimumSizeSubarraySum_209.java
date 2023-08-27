package org.practice.io.SlidingWindow;

import org.junit.Test;

public class MinimumSizeSubarraySum_209 {


  public int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;

    int startIndex = 0;
    int currentIndex = 0;

    int sum = 0;

    while (currentIndex < nums.length) {

      sum += nums[currentIndex];

      while (sum >= target) {
        min = Math.min(min, currentIndex - startIndex + 1);
        sum -= nums[startIndex];
        startIndex++;
      }

      currentIndex++;
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }


  @Test
  public void test1() {
    System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
  }
}
