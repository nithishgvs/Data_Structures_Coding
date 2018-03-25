package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class UniquePaths_62 {
  
	//Unique Paths without Obstacles!
	public static int UniquePaths(int x, int y) {

		int matrix[][] = new int[x][y];

		// Edge Cases filling
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = 1;
		}
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = 1;
		}

		// Matrix filling
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}

		}
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}

	@Test
	public void testUniquePaths() {
		System.out.println(UniquePaths(3, 4));
	}

}
