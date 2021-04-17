package org.leetcode.Arrays;

import java.util.Arrays;

public class HeightChecker_1051 {

  public int heightChecker(int[] heights) {
    int count = 0;

    int[] heights2 = heights.clone();
    Arrays.sort(heights2);

    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != heights2[i]) {
        count++;
      }

    }

    return count;
  }

}
