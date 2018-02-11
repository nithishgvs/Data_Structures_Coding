package org.leetcoode.dynamicprogramming;

import org.junit.Test;

//Unique Paths without Obstacles! 1 is obstacle 0 is safe path
public class UniquePaths2_63 {

	public int UniquePathWithObstacles(int[][] matrix) {
		int[][] tempMatrix = new int[matrix.length][matrix[0].length];

		// Edge Cases filling

		// Corner case
		if (matrix[0][0] != 1) {
			tempMatrix[0][0] = 1;
		}

		// First row case
		for (int i = 1; i < matrix[0].length; i++) {
			tempMatrix[0][i] = (tempMatrix[0][i - 1] == 1 && matrix[0][i] == 0) ? 1 : 0;
		}
		// First column case
		for (int i = 1; i < matrix.length; i++) {
			tempMatrix[i][0] = (tempMatrix[i - 1][0] == 1 && matrix[i][0] == 0) ? 1 : 0;
		}

		// Matrix filling
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] != 1) {
					tempMatrix[i][j] = tempMatrix[i - 1][j] + tempMatrix[i][j - 1];
				}
			}
		}

		return tempMatrix[matrix.length - 1][matrix[0].length - 1];
	}

	@Test
	public void testUniquePathWithObstacles() {
		int[][] matrix = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(UniquePathWithObstacles(matrix));

	}
}
