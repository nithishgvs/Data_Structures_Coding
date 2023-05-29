package org.practice.io.DynamicProgramming;

import org.junit.Test;

public class BestTimeToBuyAndSellStock_121 {

  public int maxProfit(int[] prices) {

    int maxProfit = 0;

    int[] minBuy = new int[prices.length];

    minBuy[0] = prices[0];

    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - minBuy[i - 1]);
      minBuy[i] = Math.min(prices[i], minBuy[i - 1]);
    }

    return maxProfit;

  }


  @Test
  public void test1() {
    int[] prices = {7, 6, 4, 3, 1};
    System.out.println(maxProfit(prices));
  }

}
