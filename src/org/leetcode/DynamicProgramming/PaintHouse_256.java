package org.leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PaintHouse_256 {


  public int minCost(int[][] costs) {

    if(costs.length==0){
      return 0;
    }
    int minCost = Integer.MAX_VALUE;

    int[][] dp = new int[costs.length][3];

    for (int i = 0; i < 3; i++) {
      dp[0][i] = costs[0][i];
    }

    if (costs.length == 1) {
      return Math.min(Math.min(dp[0][0], dp[0][2]),
          Math.min(Math.min(dp[0][0], dp[0][1]), Math.min(dp[0][1], dp[0][2])));
    }

    List<int[]> list = new ArrayList<>();
    list.add(new int[]{1, 2});
    list.add(new int[]{0, 2});
    list.add(new int[]{1, 0});

    for (int i = 1; i < costs.length; i++) {
      minCost = Integer.MAX_VALUE;
      for (int j = 0; j < 3; j++) {
        dp[i][j] = costs[i][j] + Math.min(dp[i - 1][list.get(j)[0]], dp[i - 1][list.get(j)[1]]);
        minCost = Math.min(minCost, dp[i][j]);
      }
    }

    return minCost;

  }


  @Test
  public void test() {
    int[][] costs = {{100, 2, 3}};
    System.out.println(minCost(costs));
  }


  @Test
  public void test1() {
    int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
    System.out.println(minCost(costs));
  }

}
