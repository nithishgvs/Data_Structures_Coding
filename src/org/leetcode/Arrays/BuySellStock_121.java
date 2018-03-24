package org.leetcode.Arrays;

public class BuySellStock_121 {

	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int minBuy = prices[0];
		int maxSell = 0;
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (minBuy > prices[i]) {
				minBuy = prices[i];
				maxSell = minBuy;
				continue;
			}
			maxSell = Math.max(maxSell, prices[i]);
			maxProfit = Math.max(maxProfit, maxSell - minBuy);

		}

		return maxProfit;
	}

}
