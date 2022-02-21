package org.twentytwentytwo.practice;

import java.util.Arrays;
import org.junit.Test;

/**
 * https://www.youtube.com/watch?v=1R0_7HqNaW0
 */
public class CoinChange_322 {


  public int coinChange(int[] coins, int amount) {

    int[] dp = new int[amount + 1];

    Arrays.fill(dp, amount + 1);

    dp[0] = 0;

    for (int i = 1; i <= amount ; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
      }
    }

    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

  @Test
  public void test1() {
    int[] coins = new int[]{2};
    System.out.println(coinChange(coins,3 ));
  }
}
