package org.leetcode.Arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PascalTriangle_119 {

	public List<Integer> getRow(int rowIndex) {
		Integer[] array = new Integer[rowIndex + 1];
		Arrays.fill(array, 0);
		array[0] = 1;

		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i; j > 0; j--) {
				array[j] = array[j] + array[j - 1];
			}
		}

		return Arrays.asList(array);
	}

	@Test
	public void testPascalTriangle() {
		System.out.println(Arrays.asList(getRow(3)));
	}

}
