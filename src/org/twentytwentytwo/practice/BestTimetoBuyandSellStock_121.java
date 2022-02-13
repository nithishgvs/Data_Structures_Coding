package org.twentytwentytwo.practice;

import org.junit.Test;

public class BestTimetoBuyandSellStock_121 {


  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minBuy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - minBuy);
      minBuy = Math.min(prices[i], minBuy);
    }

    return maxProfit;
  }


  @Test
  public void test1() {
    int[] prices = {7, 6, 4, 3, 1};
    System.out.println(maxProfit(prices));
  }
}
