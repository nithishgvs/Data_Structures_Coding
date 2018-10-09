package org.leetcode.Arrays;

import org.junit.Test;

public class BinarySearch_704 {
	public int search(int[] nums, int target) {
		int index = -1;
		int l = 0, h = nums.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return index;
	}

	@Test
	public void testBinarySearch() {
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		System.out.println(search(nums, target));
	}
}
