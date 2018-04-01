package org.leetcode.Arrays;

import org.junit.Test;

public class MaxConsecutiveOnes_485 {
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1) {
			if (nums[0] == 1)
				return 1;
			else
				return 0;
		}
		int maxOnes = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				count++;
			else {
				count = 0;
			}
			maxOnes = Math.max(maxOnes, count);
		}

		return maxOnes;

	}

	@Test
	public void testMaxConsecutiveOnes() {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		System.out.println(findMaxConsecutiveOnes(nums));
	}

}
