package org.leetcode.Arrays;

import org.junit.Test;

public class RemoveElement_27 {
	/**
	 * Two pointers concept
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int i = 0;
		int h = nums.length;
		while (i < h) {
			if (nums[i] == val) {
				nums[i] = nums[h - 1];
				h--;
			} else {
				i++;
			}

		}
		return h;
	}

	@Test
	public void removeElemTest() {
		int[] nums = { 3, 2, 2, 3 };
		int[] nums1 = { 3, 3 };
		System.out.println(removeElement(nums, 3));
	}

}
