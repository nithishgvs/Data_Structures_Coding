package org.nithishgvs.Arrays;

import java.util.Arrays;

public class AlternateHighLow {
	/**
	 * Alternate High Lows of Elements in array
	 * 
	 * @param array
	 */
	public static void arrangeAlternateHighLow(int[] array) {
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			if (j < array.length) {
				if (!flag) {
					if (array[j] < array[i]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
					flag = !flag;
				} else {
					if (array[j] > array[i]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
					flag = !flag;
				}
			}
		}

		System.out.println("After Arranging");
		System.out.println(Arrays.toString(array));

	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int[] array2 = { 9, 6, 8, 3, 7 };
		System.out.println("Before Arranging");
		System.out.println(Arrays.toString(array2));
		arrangeAlternateHighLow(array2);

	}

}
