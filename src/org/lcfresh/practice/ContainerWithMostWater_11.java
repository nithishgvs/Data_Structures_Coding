package org.lcfresh.practice;

public class ContainerWithMostWater_11 {


  public int maxArea(int[] height) {
    int area = 0;

    int start = 0, end = height.length - 1;

    while (start < end) {

      int startValue = height[start];
      int endValue = height[end];

      area = Math.max(area, Math.min(startValue, endValue) * (end - start));

      if (startValue < endValue) {
        start++;
      } else if (startValue > endValue) {
        end--;
      } else {
        start++;
        end--;
      }


    }

    return area;
  }

}
