package org.leetcode.Arrays;

import java.util.Arrays;

import org.junit.Test;

public class RotateArray_189 {

	public void rotate(int[] nums, int k) {
		if (nums.length == 0)
			return;
		k = k % nums.length;
		reverseArray(nums, 0, nums.length - k - 1);
		reverseArray(nums, nums.length - k, nums.length - 1);
		reverseArray(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private void reverseArray(int[] nums, int i, int k) {
		while (i < k) {
			int temp = nums[i];
			nums[i] = nums[k];
			nums[k] = temp;
			i++;
			k--;
		}

	}

	@Test
	public void testRotateArray() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int[] nums1 = { 1, 2 };
		rotate(nums, 3);
		// System.out.println(3 % 7);

	}

}
