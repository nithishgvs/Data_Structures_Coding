package org.nithishgvs.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class PairSum {
	/**
     *  O(n^2) time complexity
     * @param array
     * @param sum
     */
	public static void findPairSum(int[] array, int sum) {
		Arrays.sort(array);
		System.out.println("Sorted Array using Java Arrays API");
		int l = 0;
		int h = array.length - 1;
		while (l < h) {
			int temp = sum - array[l];
			if (array[h] < temp) {
				l++;
			} else if (array[h] > temp) {
				h--;
			} else if (array[h] == temp) {
				System.out.println("Elements Found. " + array[l] + "," + array[h]);
				return;
			}
		}
		System.out.println("Sum Pair not found");

	}
    /**
     * O(n) space O(n) time complexities
     * @param array
     * @param sum
     */
	public static void findPairSumHashing(int[] array, int sum) {

		HashMap<Integer, Integer> sumMap = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			if (sumMap.containsKey(sum - array[i])) {
				System.out.println("Map contains this pair: " + array[i] + ", " + (sum - array[i]));
				return;
			}else{
				sumMap.put(array[i], i);
			}
		}
		System.out.println("Sum Pair not Found!");

	}

	public static void main(String[] args) {
		int[] array = { 8, 7, 2, 5, 3, 1 };
		findPairSum(array, 12);
		findPairSumHashing(array,10);

	}

}
