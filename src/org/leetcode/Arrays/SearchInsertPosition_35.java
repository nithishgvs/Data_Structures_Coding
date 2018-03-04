package org.leetcode.Arrays;

import org.junit.Test;

public class SearchInsertPosition_35 {

	/**
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int SearchInsertPosition(int[] nums, int target) {
		int searchPosition = 0;
		int l = 0;
		int h = nums.length;

		while (l <= h) {
			int mid = (l + h) / 2;
			if (mid == nums.length) {
				return mid;
			}
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				if (h == nums.length && nums.length == 1) {
					return searchPosition;
				}
				h = mid - 1;
			} // mid<target
			else {
				if (h == nums.length) {
					if (nums[h - 1] < target && nums.length == 1) {
						return nums.length;
					}
				}
				l = mid + 1;
			}
		}
		if (l > h) {
			return l;
		}

		return searchPosition;
	}

	@Test
	public void testSearchPosition() {
		int[] array = { 2, 7, 8, 9, 11 };
		System.out.println(SearchInsertPosition(array, 12));
	}

}
