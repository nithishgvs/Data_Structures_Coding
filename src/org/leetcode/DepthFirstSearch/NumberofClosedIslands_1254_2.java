package org.leetcode.DepthFirstSearch;

import org.junit.Test;

public class NumberofClosedIslands_1254_2 {

  int count = 0;

  public int closedIsland(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int sum = 0;
    int n = grid.length;
    int m = grid[0].length;
    int[][] visited = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      if (i == 0 || i == grid.length - 1) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 0 && visited[i][j] == 0) {
            dfs(i, j, grid, visited, n, m);
          }
        }
      } else {
        if (grid[i][0] == 0 && visited[i][0] == 0) {
          dfs(i, 0, grid, visited, n, m);
        }
        if (grid[i][m - 1] == 0 && visited[i][m - 1] == 0) {
          dfs(i, m - 1, grid, visited, n, m);
        }
      }
    }
    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < m - 1; j++) {
        if (grid[i][j] == 0 && visited[i][j] == 0) {
          count++;
          System.out.println(i + "   " + j);
          dfs(i, j, grid, visited, n, m);
        }
      }
    }
    return count;
  }

  public void dfs(int i, int j, int[][] grid, int[][] visited, int n, int m) {
    if (visited[i][j] == 0) {
      visited[i][j] = 1;
      if (i > 0 && grid[i - 1][j] == 0) {
        dfs(i - 1, j, grid, visited, n, m);
      }
      if (i < n - 1 && grid[i + 1][j] == 0) {
        dfs(i + 1, j, grid, visited, n, m);
      }
      if (j > 0 && grid[i][j - 1] == 0) {
        dfs(i, j - 1, grid, visited, n, m);
      }
      if (j < m - 1 && grid[i][j + 1] == 0) {
        dfs(i, j + 1, grid, visited, n, m);
      }
    }
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
