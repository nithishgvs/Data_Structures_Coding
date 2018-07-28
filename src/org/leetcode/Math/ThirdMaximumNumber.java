package org.leetcode.Math;

import org.junit.Test;

public class ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
		long firstMax = Long.MIN_VALUE;
		long secondMax = Long.MIN_VALUE;
		long thirdMax = Long.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = nums[i];
			} else if (nums[i] > secondMax && nums[i] != firstMax) {
				thirdMax = secondMax;
				secondMax = nums[i];
			} else if (nums[i] > thirdMax && nums[i] != secondMax && nums[i] != firstMax) {
				thirdMax = nums[i];
			}
		}

		return (thirdMax == Long.MIN_VALUE) ? (int) firstMax : (int) thirdMax;
	}

	@Test
	public void testThirdMax() {
		int[] nums = { 1, -2147483648, 2 };
		System.out.println(thirdMax(nums));
	}

}
