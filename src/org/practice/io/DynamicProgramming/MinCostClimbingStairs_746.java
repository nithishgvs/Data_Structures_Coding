package org.practice.io.DynamicProgramming;

import org.junit.Test;

public class MinCostClimbingStairs_746 {


  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i < dp.length; i++) {
      if (dp[i - 1] + cost[i - 1] < dp[i - 2] + cost[i - 2]) {
        dp[i] = dp[i - 1] + cost[i - 1];
      } else {
        dp[i] = dp[i - 2] + cost[i - 2];
      }
    }

    return dp[dp.length - 1];
  }


  @Test
  public void test1() {
    int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    int[] cost2 = {0, 2, 2, 1};
    System.out.println(minCostClimbingStairs(cost2));
  }


}
