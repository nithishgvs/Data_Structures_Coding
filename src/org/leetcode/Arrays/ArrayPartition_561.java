package org.leetcode.Arrays;

import org.junit.Test;

import java.util.Arrays;

//Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
public class ArrayPartition_561 {

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i = i + 2) {
			sum += nums[i];
		}
		return sum;
	}

	@Test
	public void testArrayPartition() {
		int[] array = { 1, 4, 3, 2, 5, 7, 6, 8, 9, 10 };
		System.out.println(arrayPairSum(array));
	}
}
