package org.leetcode.Arrays;

import org.junit.Test;

public class ImageSmoother_661 {

	public int[][] imageSmoother(int[][] M) {
		int[][] smoothArray = new int[M.length][M[0].length];

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				smoothArray[i][j] = imageSmoothHelper(i, j, M);
			}
		}

		return smoothArray;

	}

	private int imageSmoothHelper(int i, int j, int[][] m) {
		int smoothValue = 0;
		int total = 0;
		for (int row = i - 1; row <= i + 1; row++) {
			for (int col = j - 1; col <= j + 1; col++) {
				if (row >= 0 && row < m.length && col >= 0 && col < m[0].length) {
					smoothValue += m[row][col];
					total++;
				}
			}
		}
		return Math.floorDiv(smoothValue, total);
	}

	@Test
	public void smootherTest() {
		int[][] M = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

		int[][] M2 = { { 2, 3, 4 }, { 5, 6, 7 }, { 8, 9, 10 }, { 11, 12, 13 }, { 14, 15, 16 } };

		imageSmoother(M2);

	}

}
