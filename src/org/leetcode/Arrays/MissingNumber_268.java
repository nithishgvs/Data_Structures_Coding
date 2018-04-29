package org.leetcode.Arrays;

public class MissingNumber_268 {

	public int missingNumber(int[] nums) {
		int length = nums.length;
		int sum = length * (length + 1) / 2;
		int actualSum = 0;
		for (int i = 0; i < length; i++) {
			actualSum += nums[i];
		}
		return sum - actualSum;
	}

}
