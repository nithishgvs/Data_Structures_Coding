package org.leetcode.Arrays;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeroes_283 {

	public void moveZeroes(int[] nums) {

		if (nums.length == 1)
			return;
		for (int i = 0; i < nums.length; i++) {
			int current = i + 1;
			if (nums[i] == 0) {

				while (current < nums.length && nums[current] == 0) {
					current++;
				}

				if (current == nums.length)
					break;

				swapNumbers(i, current, nums);
			}
		}
	}

	private void swapNumbers(int i, int current, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[current];
		nums[current] = temp;

	}

	@Test
	public void moveZeroesTest() {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

}
