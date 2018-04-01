package org.leetcode.Arrays;

import java.util.HashMap;

import org.junit.Test;

public class KDiffPairsArray_532 {

	/**
	 * Checked Discussions
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */

	public int findPairs(int[] nums, int k) {
		if (k < 0)
			return 0;

		int pairs = 0;

		HashMap<Integer, Integer> hMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (!hMap.containsKey(nums[i])) {
				if (hMap.containsKey((nums[i] + k))) {
					pairs++;
				}
				if (hMap.containsKey((nums[i] - k))) {
					pairs++;
				}
				hMap.put(nums[i], 0);
			} else if (k == 0 && hMap.get(nums[i]) == 0) {
				pairs++;
				hMap.put(nums[i], 1);
			}

		}

		return pairs;

	}

	@Test
	public void testKDiffPairs() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] nums2 = { 1, 3, 1, 5, 4 };
		int[] nums3 = { 3, 1, 4, 1, 5 };
		System.out.println(findPairs(nums2, 0));

	}
}
