package org.twentytwentytwo.practice;

import org.junit.Test;

public class TrappingRainWater_42 {


  public int trap(int[] height) {

    int water = 0;

    int maxSoFar = 0;
    int[] maxRight = new int[height.length];

    int maxLeft = 0;

    for (int i = height.length - 1; i >= 0; i--) {
      if (height[i] > maxSoFar) {
        maxSoFar = height[i];
        maxRight[i] = height[i];
      } else {
        maxRight[i] = maxSoFar;
      }
    }

    for (int i = 0; i < height.length; i++) {
      water += Integer.max(Integer.min(maxLeft, maxRight[i]) - height[i], 0);
      if (height[i] > maxLeft) {
        maxLeft = height[i];
      }
    }

    return water;
  }


  @Test
  public void test1() {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap((height)));
  }

}
