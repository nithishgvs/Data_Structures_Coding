package org.leetcode.Arrays;

import org.junit.Test;

public class SearchInsertPositionRec_35 {

	public int searchInsert(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private int binarySearch(int[] nums, int target, int start, int end) {
		int mid = (start + end) / 2;
		if (start <= end) {
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				return binarySearch(nums, target, start, mid - 1);
			} else {
				return binarySearch(nums, target, mid + 1, end);
			}
		}
		return start;
	}

	@Test
	public void testSearchPosition() {
		int[] array = { 2, 7, 8, 9, 11 };
		System.out.println(searchInsert(array, 9));
	}

}
