package org.leetcode.Arrays;

import org.junit.Test;

public class ContainerWithMostWater_11 {

  public int maxArea(int[] height) {

    int max = 0;

    int left = 0, right = height.length - 1;

    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

      if (height[right] < height[left]) {
        right--;
      } else {
        left++;
      }
    }

    return max;

  }

  @Test
  public void test1() {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 3}));
  }

  @Test
  public void test2() {
    System.out.println(maxArea(new int[]{2, 0}));
  }


}
