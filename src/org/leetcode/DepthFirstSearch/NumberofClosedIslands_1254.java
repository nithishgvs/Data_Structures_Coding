package org.leetcode.DepthFirstSearch;

import org.junit.Test;

public class NumberofClosedIslands_1254 {

  int closedIslands = 0;

  public int closedIsland(int[][] grid) {

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 0) {
          helperClosedIslands(grid, visited, i, j, true);
        }
      }
    }

    return closedIslands;
  }

  private boolean helperClosedIslands(int[][] grid, boolean[][] visited, int row, int column,
      boolean fromRoot) {

    if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
      return false;
    }
    if (grid[row][column] == 0) {
      if (!visited[row][column]) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        visited[row][column] = true;
        boolean one = helperClosedIslands(grid, visited, dirs[0][0] + row, dirs[0][1] + column,
            false);
        boolean two = helperClosedIslands(grid, visited, dirs[1][0] + row, dirs[1][1] + column,
            false);
        boolean three = helperClosedIslands(grid, visited, dirs[2][0] + row, dirs[2][1] + column,
            false);
        boolean four = helperClosedIslands(grid, visited, dirs[3][0] + row, dirs[3][1] + column,
            false);
        if (one && two && three && four) {
          //all ones i.e enclosed by water
          if (fromRoot) {
            System.out.println("row: " + row + " ," + " column: " + column);
            closedIslands++;
          } else {
            return true;
          }
        }
        return false;
      }
    }
    return true;
  }


  @Test
  public void test1() {
    System.out
        .println(closedIsland(new int[][]{{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}}));
  }

  @Test
  public void test2() {
    System.out
        .println(closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}}));
  }

  @Test
  public void test3() {
    System.out
        .println(closedIsland(
            new int[][]{{1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}}));
  }

  @Test
  public void test4() {
    System.out
        .println(closedIsland(
            new int[][]{{1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}}));
  }


  @Test
  public void test5() {
    System.out
        .println(closedIsland(
            new int[][]{{0, 0, 1, 1, 0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}}));
  }

}
