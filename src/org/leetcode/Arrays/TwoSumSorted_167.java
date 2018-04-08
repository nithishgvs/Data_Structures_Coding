package org.leetcode.Arrays;

import org.junit.Test;

public class TwoSumSorted_167 {

	public int[] twoSum(int[] numbers, int target) {
		if (numbers.length < 2) {
			return null;
		}
		int[] indexArray = new int[2];
		int l = 0;
		int h = numbers.length-1;
		while (l < h) {
			int tempSum = target - numbers[l];
			if (tempSum == numbers[h]) {
				indexArray[0] = l+1;
				indexArray[1] = h+1;
				break;
			}
			if (tempSum < numbers[h])
				h--;
			else
				l++;
		}
		return indexArray;
	}

	@Test
	public void twoSumTest() {
		int numbers[] = { 2, 7, 11, 15 };
		twoSum(numbers, 9);
	}

}
