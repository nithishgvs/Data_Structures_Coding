package org.twentytwentytwo.practice;

public class BestTimetoBuyandSellStockwithCooldown_309 {

  /**
   * dp[len][2]
   *
   *
   * 1th index means has stock and 0th means doesnt have stock
   *
   * dp[i][0] has no stock includes 2 scenarios
   *
   * scenario 1 : sold it that means i possess stock on day -1 and value will be
   * dp[i-1][1]+prices[i] scenario2: carry forwarding means nothing dp[i-1][0]
   *
   * dp[i][1] has stock includes 2 scenarios
   *
   * scenario 1: has stock on i-2th day dp[i-2][1]-prices[i] scenario2 : carryforwarding means
   * nothing dp[i-1][1]
   */
  public int maxProfit(int[] prices) {

    if (prices.length == 1) {
      return 0;
    }

    if (prices.length == 2 && prices[0] < prices[1]) {
      return prices[1]-prices[0];
    }

    if (prices.length == 2 && prices[0] > prices[1]) {
      return 0;
    }

    int[][] dp = new int[prices.length][2];

    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
    dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

    for (int i = 2; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
    }

    return dp[prices.length - 1][0];

  }

}
