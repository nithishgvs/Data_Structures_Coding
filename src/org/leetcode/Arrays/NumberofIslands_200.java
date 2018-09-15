package org.leetcode.Arrays;

public class NumberofIslands_200 {

	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];
		int numIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visitedGrid[i][j]) {
					numIslands++;
					dfsGrid(i, j, visitedGrid, grid);
				}
			}
		}
		return numIslands;
	}

	private void dfsGrid(int row, int col, boolean[][] visitedGrid, char[][] grid) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visitedGrid[row][col]
				|| grid[row][col] != '1')
			return;
		visitedGrid[row][col] = true;
		dfsGrid(row - 1, col, visitedGrid, grid);
		dfsGrid(row, col - 1, visitedGrid, grid);
		dfsGrid(row, col + 1, visitedGrid, grid);
		dfsGrid(row + 1, col, visitedGrid, grid);

	}

}
