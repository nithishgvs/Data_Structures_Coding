package org.leetcode.Arrays;

import org.junit.Test;

public class MaximumSubarray_53 {

	public int maxSubArray(int[] nums) {
		int currentMax = nums[0];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum < nums[i]) {
				sum = nums[i];
			}
			if (sum > currentMax) {
				currentMax = sum;
			}
		}
		return currentMax;
	}

	@Test
	public void testMaxSubArr() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

}
