package org.twentytwentytwo.practice;

import java.util.List;

public class Triangle_120 {

  public int minimumTotal(List<List<Integer>> triangle) {
    int lastRow = triangle.get(triangle.size() - 1).size();

    int[] dp = new int[lastRow];

    for (int i = 0; i < lastRow; i++) {
      dp[i] = triangle.get(triangle.size() - 1).get(i);
    }

    for (int i = triangle.size() - 2; i > -1; i--) {

      List<Integer> currentRow = triangle.get(i);

      for (int j = 0; j < currentRow.size(); j++) {
        int minFromPrevRow = Math.min(dp[j], dp[j + 1]);
        dp[j] = minFromPrevRow + currentRow.get(j);
      }

    }

    return dp[0];
  }
}
