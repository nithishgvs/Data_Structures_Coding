package org.practice.io.TwoPointers;

import org.junit.Test;

public class ContainerWithMostWater_11 {


  public int maxArea(int[] height) {

    int start = 0;
    int end = height.length - 1;

    int maxArea = 0;

    while (start <= end) {

      int startValue = height[start];
      int endValue = height[end];

      maxArea = Math.max(maxArea, (end - start) * Math.min(startValue, endValue));

      if (startValue > endValue) {
        end--;
      } else if (startValue < endValue) {
        start++;
      } else {
        start++;
        end--;
      }

    }

    return maxArea;
  }

  @Test
  public void test() {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

}
