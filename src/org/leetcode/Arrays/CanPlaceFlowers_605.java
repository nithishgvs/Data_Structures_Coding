package org.leetcode.Arrays;

import org.junit.Test;

public class CanPlaceFlowers_605 {

	// Greedy concept being used here
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {

		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0 && isValidLocation(i, flowerbed)) {
				flowerbed[i] = 1;
				n--;
			}
		}

		return (n <= 0);
	}

	private static boolean isValidLocation(int i, int[] flowerbed) {
		// Single element array
		if (flowerbed.length == 1 && flowerbed[0] == 0) {
			return true;
		}
		// Checking adjacent elements
		if (i - 1 > 0 && i + 1 < flowerbed.length) {
			if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1)
				return true;
		}
		// First and last element being 0 scenario
		if ((i == 0 && flowerbed[i + 1] == 0) || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0))
			return true;

		return false;
	}

	@Test
	public void testPlaceFlowers() {
		int[] arr1 = { 1, 0, 0, 0, 0, 1 };

		int[] arr2 = { 0, 0, 1, 0, 0 };

		System.out.println(canPlaceFlowers(arr2, 1));
	}

}
