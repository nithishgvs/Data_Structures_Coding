package org.leetcode.Bracktracking;

import org.junit.Test;

public class StringPermutation {

	public void stringPermutation(char[] stringArr, int i, int j) {
		if (i == j)
			System.out.println(new String(stringArr));

		for (int k = i; k <= j; k++) {
			swap(stringArr, i, k);
			stringPermutation(stringArr, i + 1, j);
			swap(stringArr, i, k);
		}

	}

	private void swap(char[] stringArr, int i, int j) {
		char temp = stringArr[i];
		stringArr[i] = stringArr[j];
		stringArr[j] = temp;
	}

	@Test
	public void teststringPermutation() {
		stringPermutation("ABC".toCharArray(), 0, 2);
	}

}
