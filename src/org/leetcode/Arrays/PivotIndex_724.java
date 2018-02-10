package org.leetcode.Arrays;

import org.junit.Test;

//We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
public class PivotIndex_724 {

	public static int findPivotIndex(int[] array) {
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		int leftSum = array[leftIndex];
		int rightSum = array[rightIndex];

		while (leftIndex < rightIndex-1) {
			if (leftSum < rightSum) {
				leftSum += array[++leftIndex];
			} else if (leftSum > rightSum) {
				rightSum += array[--rightIndex];
			} else  {
				System.out.println("Pivot Index Found");
				return rightIndex - leftIndex + 1;
			}
		}
		return -1;
	}

	@Test
	public void testPivotIndex1() {
		int array[] = { 1, 7, 3, 6, 5, 6 };
		System.out.println(findPivotIndex(array));
	}

	@Test
	public void testPivotIndex2() {
		int array[] = { 1, 7, 3, 6, 5 };
		System.out.println(findPivotIndex(array));
	}

}
