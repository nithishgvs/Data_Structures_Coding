package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class CoinChange1 {


  public int coinChange(int[] coins, int sum) {
    int[][] coinMatrix = new int[coins.length + 1][sum + 1];
    for (int i = 0; i < coins.length + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (j == 0) {
          coinMatrix[i][j] = 1;
        } else {
          if (i > j) {
            coinMatrix[i][j] = coinMatrix[i - 1][j];
          } else {
            if (i - 1 >= 0 && j - i >= 0) {
              coinMatrix[i][j] = coinMatrix[i - 1][j] + coinMatrix[i][j - i];
            }
          }
        }

      }
    }
    return coinMatrix[coins.length][sum];
  }


  @Test
  public void testCoinChange() {
    int[] coins = {1, 2, 3, 4, 5};
    System.out.println(coinChange(coins, 5));
  }


}
