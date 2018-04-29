package org.leetcode.Arrays;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortedArray_88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums1Index = m - 1, nums2Index = n - 1;
		int totalIndex = m + n - 1;

		while (totalIndex >= 0) {
			if (nums1Index < 0 || (nums2Index >= 0 && nums1[nums1Index] < nums2[nums2Index])) {
				nums1[totalIndex] = nums2[nums2Index];
				nums2Index--;
			} else {
				nums1[totalIndex] = nums1[nums1Index];
				nums1Index--;
			}
			totalIndex--;
		}

		System.out.println(Arrays.toString(nums1));

	}

	@Test

	public void testMerge() {
		// { 1, 2, 3, 0, 0, 0 }, { 2, 5, 6 },{ 4, 0, 0, 0, 0, 0 },{ 1, 2, 3, 5,
		// 6 }
		int[] nums1 = { 4, 0, 0, 0, 0, 0 };
		int[] nums2 = { 1, 2, 3, 5, 6 };
		int m = 1;
		int n = 5;
		merge(nums1, m, nums2, n);

	}

}
