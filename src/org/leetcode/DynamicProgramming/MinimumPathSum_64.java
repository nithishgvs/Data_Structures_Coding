package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class MinimumPathSum_64 {

  public int minPathSum(int[][] grid) {

    for (int i = 1; i < grid[0].length; i++) {
      grid[0][i] = grid[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < grid.length; i++) {
      grid[i][0] = grid[i - 1][0] + grid[i][0];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
      }
    }

    return grid[grid.length - 1][grid[0].length - 1];

  }


  @Test
  public void testMinPath1() {
    int[][] grid = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    System.out.println(minPathSum(grid));
  }


  @Test
  public void testMinPath2() {
    int[][] grid = {
        {1, 2, 5},
        {3, 2, 1}
    };
    System.out.println(minPathSum(grid));
  }


}
