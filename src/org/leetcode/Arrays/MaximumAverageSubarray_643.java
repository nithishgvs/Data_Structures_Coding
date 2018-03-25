package org.leetcode.Arrays;

import org.junit.Test;

public class MaximumAverageSubarray_643 {
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage(int[] nums, int k) {
		double maxAverage = Integer.MIN_VALUE;
		int sumTillNow = 0;
		int i = 0;
		while (nums.length - i > k - 1) {
			for (int j = i; (j - i) < k && j < nums.length; j++) {
				sumTillNow = sumTillNow + nums[j];
			}
			maxAverage = Math.max(maxAverage, (double) sumTillNow / k);
			sumTillNow = 0;
			i++;
		}

		return maxAverage;
	}

	@Test
	public void testMaxAverage() {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int[] nums2 = { -1 };
		System.out.println(findMaxAverage(nums, 4));
	}

}
