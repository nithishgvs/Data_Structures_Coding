package org.nithishgvs.Arrays;

import java.util.HashMap;

public class ZeroSum {

	public static boolean getZeroSumArray(int[] array) {
		int sum = 0;
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (array[i] == 0 || sum == 0 || sumMap.get(sum) != null) {
				return true;
			} else {
				sumMap.put(sum, i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int array[] = { 4, 2, -3, 1, 6 };
		if (getZeroSumArray(array))
			System.out.println("Found a subarray with 0 sum");
		else
			System.out.println("No Subarray with 0 sum");

	}

}
