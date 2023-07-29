package org.practice.io.DynamicProgramming;

import java.util.Arrays;
import org.junit.Test;

public class CoinChange_322 {


  public int coinChange(int[] coins, int amount) {

    int[] dp = new int[amount + 1];

    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i >= coins[j]) {
          dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);
        }
      }

    }

    return dp[amount] > amount ? -1 : dp[amount];
  }


  @Test
  public void test1() {
    System.out.println(coinChange(new int[]{2}, 0));
  }
}
