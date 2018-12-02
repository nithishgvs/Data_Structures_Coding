package org.leetcode.DynamicProgramming;

import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class CoinChange_322 {

  public int coinChange(int[] coins, int amount) {

    int[] coinArrayDp = new int[amount + 1];
    Set<Integer> amountSet = new TreeSet<>();
    for (Integer coin : coins) {
      amountSet.add(coin);
    }
    for (int i = 1; i < coinArrayDp.length; i++) {
      if (amountSet.contains(i)) {
        coinArrayDp[i] = 1;
      } else {
        coinArrayDp[i] = Integer.MAX_VALUE;
        for (Integer coin : coins) {
          if (coin < i && coinArrayDp[i - coin] != Integer.MAX_VALUE
              && coinArrayDp[coin] != Integer.MAX_VALUE) {
            coinArrayDp[i] = Math.min(coinArrayDp[i], coinArrayDp[i - coin] + coinArrayDp[coin]);
          }
        }

      }
    }

    return coinArrayDp[amount] != Integer.MAX_VALUE ? coinArrayDp[amount] : -1;
  }


  @Test
  public void testCoinChange() {
    int[] coins = {1, 2, 5};
    System.out.println(coinChange(coins, 11));
  }

  @Test
  public void testCoinChange2() {
    int[] coins = {2};
    System.out.println(coinChange(coins, 3));
  }

  @Test
  public void testCoinChange1() {
    int[] coins = {186, 419, 83, 408};
    System.out.println(coinChange(coins, 6249));
  }

}
