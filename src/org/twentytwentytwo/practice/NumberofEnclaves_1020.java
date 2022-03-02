package org.twentytwentytwo.practice;

public class NumberofEnclaves_1020 {

  public int numEnclaves(int[][] grid) {

    int count = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1 && (row == 0 || row == grid.length - 1 || col == 0
            || col == grid[0].length - 1)) {
          helper(grid, row, col);
        }
      }
    }

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          count++;
        }
      }
    }
    return count;

  }

  private void helper(int[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
      return;
    }
    grid[row][col] = 0;
    helper(grid, row - 1, col);
    helper(grid, row, col - 1);
    helper(grid, row, col + 1);
    helper(grid, row + 1, col);

  }

}
