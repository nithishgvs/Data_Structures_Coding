package org.leetcode.Strings;

import org.junit.Test;

import java.util.Arrays;

public class PeakIndexMountainArray_852 {

	public int peakIndexInMountainArray(int[] A) {
		int[] temp = Arrays.copyOf(A, A.length);
		Arrays.sort(A);
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == A[A.length - 1]) {
				return i;
			}
		}

		return -1;

	}

	@Test
	public void testPeakIndex() {
		int[] A = { 0, 2, 1, 0 };
		System.out.println(peakIndexInMountainArray(A));
	}
}
