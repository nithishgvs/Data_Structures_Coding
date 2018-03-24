package org.leetcode.Arrays;

import java.util.Arrays;

import org.junit.Test;

public class ShortestUnsortedContinuousSubarray_581 {
	/**
	 * Extra space taken(Sorted Array in extra space) .Please try to do with out
	 * wasting space
	 * 
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray(int[] nums) {
		int startIndex = 0;
		int endIndex = 0;
		boolean flag = true;

		int[] copyArray = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copyArray);

		for (int i = nums.length - 1; i >= 0; i--) {
			if (copyArray[i] != nums[i]) {
				if (flag) {
					endIndex = i;
					flag = !flag;
				} else {
					startIndex = i;
				}
			}

		}

		return (endIndex > startIndex) ? (endIndex - startIndex + 1) : 0;

	}

	@Test
	public void testUnsortedArray() {

		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		int[] nums2 = { 1, 2, 3, 4 };
		int[] nums1 = { 2, 1 };
		int[] nums3 = { 5, 4, 3, 2, 1 };
		int[] nums4 = { 1, 3, 2, 2, 2 };
		System.out.println(findUnsortedSubarray(nums3));

	}

}
