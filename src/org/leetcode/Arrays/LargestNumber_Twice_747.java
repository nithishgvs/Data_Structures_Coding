package org.leetcode.Arrays;

import org.junit.Test;

public class LargestNumber_Twice_747 {

	public static int LargestNumberTwiceOthers(int[] array) {

		// finding max of array ..Index should not change
		int max_index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[max_index]) {
				max_index = i;
			}
			System.out.println("Max index: " + max_index);
			for (i = 0; i < array.length; i++) {
				if (i != max_index && array[max_index] < 2 * array[i]) {
					return -1;
				}
			}
		}
		return max_index;
	}

	@Test
	public void testLargestNumberTwiceOthers() {
		int[] array = { 3, 6, 1, 0 };
		System.out.println(LargestNumberTwiceOthers(array));
	}
}
