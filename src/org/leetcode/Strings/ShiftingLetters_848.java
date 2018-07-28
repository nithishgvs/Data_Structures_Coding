package org.leetcode.Strings;

import org.junit.Test;

public class ShiftingLetters_848 {

	// More math a Ascii 97 z Ascii 122
	public String shiftingLetters2(String S, int[] shifts) {

		char[] arr = S.toCharArray();

		// Prepare Shifting array
		int[] shiftingArray = new int[shifts.length];

		int count = 0;
		for (int i = shifts.length - 1; i >= 0; i--) {
			count = (count + shifts[i]) % 26;
			shiftingArray[i] = count;
		}

		for (int i = 0; i < arr.length; i++) {
			int val = arr[i] + shiftingArray[i];
			if (val > 122) {
				val = val % 122;
				val = val + 96;
			}
			arr[i] = (char) val;
		}

		return new String(arr);
	}

	@Test
	public void testShiftingLetters() {
		int[] data = { 3, 5, 9 };
		int[] data1 = { 70, 41, 71, 72, 73, 84 };
		int[] data2 = { 10, 20, 30 };
		String z = "bad";
		System.out.println(shiftingLetters2(z, data2));
	}

	@Test
	public void testShiftingLetters2() {
		int[] data = { 26, 9, 17 };
		int[] data1 = { 70, 41, 71, 72, 73, 84 };
		int[] data2 = { 10, 20, 30 };
		String z = "ruu";
		System.out.println((int) ('l'));
		System.out.println(shiftingLetters2(z, data));
	}

}
