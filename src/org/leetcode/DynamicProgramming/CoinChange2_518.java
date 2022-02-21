package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class CoinChange2_518 {


  public int change(int amount, int[] coins) {
    int[][] coinMatrix = new int[coins.length + 1][amount + 1];

    coinMatrix[0][0] = 1;

    for (int i = 1; i < coins.length + 1; i++) {
      for (int j = 0; j < amount + 1; j++) {
        if (j == 0) {
          coinMatrix[i][j] = 1;
        } else {
          if (coins[i - 1] > j) {
            coinMatrix[i][j] = coinMatrix[i - 1][j];
          } else {
            if (i - 1 >= 0 && j - coins[i - 1] >= 0) {
              coinMatrix[i][j] = coinMatrix[i - 1][j] + coinMatrix[i][j - coins[i - 1]];
            }
          }
        }

      }
    }
    return coinMatrix[coins.length][amount];

  }

  @Test
  public void testCoinChange() {
    int[] coins = {1, 2, 5};
    System.out.println(change(5, coins));
  }

  @Test
  public void testCoinChange2() {
    int[] coins = {2,3};
    System.out.println(change(5, coins));
  }

  @Test
  public void testCoinChange1() {
    int[] coins = {1, 2, 5};
    System.out.println(change(11, coins));
  }
}
