package org.leetcode.Arrays;

public class RemDupSorArray_26 {

	/**
	 * Given a sorted array, remove the duplicates in-place such that each
	 * element appear only once and return the new length.
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

}
