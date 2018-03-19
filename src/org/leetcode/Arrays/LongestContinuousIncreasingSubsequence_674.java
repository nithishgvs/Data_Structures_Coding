package org.leetcode.Arrays;

import org.junit.Test;

public class LongestContinuousIncreasingSubsequence_674 {

	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 1)
			return 1;
		if (nums.length == 0)
			return 0;

		int max_Current = 1;
		int max_tillNow = 0;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] > nums[i - 1]) {
				max_Current++;
			} else  {
				max_Current = 1;
			}
			max_tillNow = Math.max(max_Current, max_tillNow);
		}
		

		return max_tillNow;

	}

	@Test
	public void testfindLengthOfLCIS() {

		int[] nums = { 1, 3, 5, 4, 2, 3, 4, 5 };
		int[] abs = { 2, 1, 3 };
		int[] nums2 = { 1, 3, -5, 4, -7, 8, 9, 10, 11, 0, -2, -3, -6 };

		System.out.println(findLengthOfLCIS(abs));

	}

}
