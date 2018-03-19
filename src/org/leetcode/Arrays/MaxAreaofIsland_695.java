package org.leetcode.Arrays;

import org.junit.Test;

/**
 * Referred Aman's code .Get better with DFS
 * @author nithishgvs
 *
 */

public class MaxAreaofIsland_695 {

	public int maxAreaOfIsland(int[][] grid) {
		int size = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int maxLength = dfsMatrix(i, j, grid);
					size = Math.max(size, maxLength);
				}
			}

		}
		return size;
	}

	private int dfsMatrix(int i, int j, int[][] grid) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;

		return 1 + dfsMatrix(i + 1, j, grid) + dfsMatrix(i - 1, j, grid) + dfsMatrix(i, j + 1, grid)
				+ dfsMatrix(i, j - 1, grid);

	}

	@Test
	public void findNoOfIslands() {
		int[][] matrix = { { 1, 1 }, { 1, 0 } };
		System.out.println(maxAreaOfIsland(matrix));
	}

}
