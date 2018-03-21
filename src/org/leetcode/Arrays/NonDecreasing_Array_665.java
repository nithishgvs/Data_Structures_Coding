package org.leetcode.Arrays;

import org.junit.Test;

public class NonDecreasing_Array_665 {

	/**
	 * Verified outside material
	 * 
	 * http://massivealgorithms.blogspot.com/2017/08/leetcode-665-non-decreasing-array.html
	 * 
	 * @param nums
	 * @return
	 */

	public boolean checkPossibility(int[] nums) {
		boolean breakingFlag = false;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= nums[i - 1]) {
				continue;
			} else {
				if (breakingFlag)
					return false;
				if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
					nums[i] = nums[i - 1];
				} else {
					nums[i - 1] = nums[i];
				}
				breakingFlag = true;
			}
		}

		return true;
	}

	@Test
	public void checkPossiblityTest() {
		int[] nums = { 4, 2, 3 };
		int[] nums1 = { 1, 1, 1 };
		System.out.println(checkPossibility(nums));
	}

}
