package org.leetcode.Arrays;

import org.junit.Test;

public class MinCostClimbingStairs_746 {

	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length];
		dp[0] = cost[0];
		dp[1] = cost[1];
		int i;
		// The logic is to cross the end of array-As discussed with Aman
		for (i = 2; i < cost.length; i++) {
			dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
		}

		return Math.min(dp[i - 1], dp[i - 2]);

	}

	@Test
	public void test() {
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs(cost));
	}

}
