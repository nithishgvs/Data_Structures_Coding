package org.leetcode.Arrays;

import org.junit.Test;

public class TwiceofOthers_747 {

	public static int LargestNumberAtLeastTwiceofOthers(int[] nums) {
		int maxNum = 0;
		int maxIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxNum) {
				maxNum = nums[i];
				maxIndex = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i != maxIndex && !(2 * nums[i] <= maxNum)) {
				return -1;
			}
		}

		return maxIndex;

	}

	@Test
	public void testTwiceofOthers() {
		int[] array = { 3, 6, 1, 0 };
		int[] array2 = { 1 };
		System.out.println(LargestNumberAtLeastTwiceofOthers(array));
	}

}
