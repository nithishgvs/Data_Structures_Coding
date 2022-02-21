package org.twentytwentytwo.practice;

import org.junit.Test;

public class CoinChange2_518 {


  public int change(int amount, int[] coins) {

    int[][] dp = new int[coins.length + 1][amount + 1];

    dp[0][0] = 1;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (coins[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
        }
      }
    }

    return dp[coins.length][amount];
  }


  @Test
  public void test1() {
    int[] coins = new int[]{1, 2, 5};
    System.out.println(change(5, coins));
  }
}
