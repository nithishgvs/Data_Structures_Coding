package org.leetcode.Arrays;

import java.util.Arrays;

public class MaximumProductThreeNumbers_628 {

	/**
	 * Did by checking discussion board but the idea is crazy .Have a look once
	 * again
	 * 
	 * @param nums
	 * @return
	 */
	public int maximumProduct(int[] nums) {

		Arrays.sort(nums);
		return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
				nums[0] * nums[1] * nums[nums.length - 1]);

	}
}
