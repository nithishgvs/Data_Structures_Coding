package org.leetcode.Arrays;

import org.junit.Test;

public class ToeplitzMatrix_766 {

	/**
	 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has
	 * the same element
	 * 
	 * @param matrix
	 * @return
	 */
	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[0].length - 1; j++) {
				if (matrix[i][j] == matrix[i + 1][j + 1]) {
					continue;
				} else {
					return false;
				}
			}

		}
		return true;
	}

	@Test
	public void toeplitzPositiveCase() {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		System.out.println(isToeplitzMatrix(matrix));
	}

	@Test
	public void toeplitzNegativeCase() {
		int[][] matrix = { { 1, 2 }, { 2, 2 } };
		System.out.println(isToeplitzMatrix(matrix));
	}

}
