package org.leetcode.Arrays;

import org.junit.Test;

public class MaxIslandSize {

	public static int countMaxIslandSize(int[][] grid) {

		int size = 0;

		boolean[][] visitedMatrix = new boolean[grid.length][grid[0].length];

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (!visitedMatrix[row][col] && grid[row][col] == 1) {
					visitedMatrix[row][col] = true;
					int maxResult = dfsMatrix(row, col, grid, visitedMatrix);
					return Math.max(size, maxResult);
				}
			}

		}

		return size;

	}

	private static int dfsMatrix(int row, int col, int[][] matrix, boolean[][] visitedMatrix) {

		int size = 1;

		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (validMatrix(r, c, matrix, visitedMatrix)) {
					System.out.println("Indices: " + r + "," + c);
					size += dfsMatrix(r, c, matrix, visitedMatrix);
				}

			}
		}

		return size;

	}

	private static boolean validMatrix(int i, int j, int[][] matrix, boolean[][] visitedMatrix) {

		if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length)) {

			if (matrix[i][j] == 1 && !visitedMatrix[i][j]) {
				visitedMatrix[i][j] = true;
				return true;
			}
			visitedMatrix[i][j] = true;
		}

		return false;

	}

	@Test
	public void findNoOfIslands() {
		int[][] matrix = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 } };
		System.out.println(countMaxIslandSize(matrix));
	}

}
