package org.leetcode.Arrays;

import org.junit.Test;

public class JumpGame_55 {

	public boolean canJump(int[] nums) {
		for (int i = 0; i < nums.length;) {
			if (nums.length == 1)
				return true;
			int currentMax = nums[i];
			int k = nums[i] + i;
			if (i + currentMax >= nums.length - 1)
				return true;
			if (nums[k] == 0)
				currentMax = 0;
			if (i == k)
				return false;
			for (int j = i + 1; j <= nums[i] + i && j < nums.length; j++) {
				if (nums[j] >= currentMax) {
					currentMax = nums[j];
					k = j;
				}
			}
			i = k;
		}
		return false;
	}

	@Test
	public void testCanJump() {
		int[] nums = { 2, 3, 1, 1, 4 };
		int[] nums2 = { 3, 2, 1, 0, 4 };
		int[] nums3 = { 2, 0 };
		int[] nums4 = { 1, 1, 2, 2, 0, 1, 1 };
		int[] nums5 = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
		System.out.println(canJump(nums3));
	}

}
