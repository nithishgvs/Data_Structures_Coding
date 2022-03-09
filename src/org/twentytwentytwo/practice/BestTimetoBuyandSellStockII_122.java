package org.twentytwentytwo.practice;

import org.junit.Test;

public class BestTimetoBuyandSellStockII_122 {

  public int maxProfit(int[] prices) {

    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }

    return profit;
  }


  @Test
  public void test() {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));
  }
}
