package org.twentytwentytwo.practice;

import org.junit.Test;

public class CountingBits_338 {


  public int[] countBits(int n) {

    int[] dp = new int[n + 1];
    dp[0] = 0;
    int mostSignificantBit = 1;

    for (int i = 1; i <= n; i++) {
      if (mostSignificantBit * 2 == i) {
        mostSignificantBit = i;
      }
      dp[i] = 1 + dp[i - mostSignificantBit];
    }
    return dp;
  }


  @Test
  public void test() {
    System.out.println(countBits(4));
  }
}
