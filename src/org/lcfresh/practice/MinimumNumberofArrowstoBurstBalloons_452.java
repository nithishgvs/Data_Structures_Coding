package org.lcfresh.practice;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons_452 {

  public int findMinArrowShots(int[][] points) {
    int arrow = 1;
    Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
    int pos = points[0][1];

    for (int i = 1; i < points.length; i++) {
      if (pos >= points[i][0]) {
        continue;
      }
      arrow++;
      pos = points[i][1];
    }

    return arrow;

  }


}
