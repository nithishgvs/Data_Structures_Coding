package org.leetcode.Arrays;

import org.junit.Test;

/**
 * Number of Islands or Clusters Ideserve Video
 * 
 * @author nithishgvs
 *
 */
public class IslandorClusters {

	/**
	 * This is DFS concept and gives u solid understanding
	 * 
	 * @param matrix
	 * @return
	 */
	public static int CountNofIslandsOrClusters(int[][] matrix) {
		int clusterCount = 0;

		boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (!visitedMatrix[row][col] && matrix[row][col] == 1) {
					clusterCount++;
					visitedMatrix[row][col] = true;
					dfsMatrix(matrix, row, col, visitedMatrix);
				}
			}

		}

		return clusterCount;
	}

	private static void dfsMatrix(int[][] matrix, int row, int col, boolean[][] visitedMatrix) {
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (isNeighboursafe(matrix, r, c, visitedMatrix)) {
					System.out.println("Indices: " + r + "," + c);
					dfsMatrix(matrix, r, c, visitedMatrix);
				}

			}
		}
	}

	public static boolean isNeighboursafe(int[][] matrix, int row, int col, boolean[][] visitedMatrix) {
		if ((row < matrix.length && col < matrix[0].length) && (row >= 0 && col >= 0)) {
			if (!visitedMatrix[row][col] && matrix[row][col] == 1) {
				visitedMatrix[row][col] = true;
				return true;
			}
		}
		return false;
	}

	@Test
	public void findNoOfIslands() {
		int[][] matrix = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 } };
		System.out.println(CountNofIslandsOrClusters(matrix));
	}
}
