package org.leetcode.Arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {

	@Test
	public void testTwoSum() {
		int[] array = { 2, 5, 7, 8, 9, 3, 1, 16 };
		int target = 13;
		int[] twoSum = twoSumNoSorting(array, target);
		System.out.println(Arrays.toString(twoSum));
	}

	/**
	 * With Sorting
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private int[] twoSumWithSorting(int[] nums, int target) {
		int[] twoSum = new int[2];
		Arrays.sort(nums);
		int l = 0;
		int h = nums.length - 1;
		while (l < h) {
			int sum = target - nums[l];
			if (sum < nums[h]) {
				h--;
			} else if (sum > nums[h]) {
				l++;
			} else {
				twoSum[0] = l;
				twoSum[1] = h;
				break;
			}
		}
		return twoSum;
	}
    /**
     * 
     * @param nums
     * @param target
     * @return
     */
	private int[] twoSumNoSorting(int[] nums, int target) {
		int[] twoSum = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int sum = target - nums[i];
			if (map.containsKey(sum) && map.get(sum) != i) {
				twoSum[0] = i;
				twoSum[1] = map.get(sum);
			}
		}
		return twoSum;
	}
}
