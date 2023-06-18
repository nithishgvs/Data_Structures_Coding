package org.practice.io.Graph;

import org.junit.Test;

public class NumberOfIslands_200 {


  public int numIslands(char[][] grid) {

    int number = 0;

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          number++;
          dfsChecker(visited, i, j, grid);
        }
      }
    }

    return number;
  }

  private void dfsChecker(boolean[][] visited, int row, int column, char[][] grid) {

    if (row > -1 && row < grid.length && column > -1 && column < grid[0].length) {
      if (grid[row][column] == '1' && !visited[row][column]) {
        int[][] adjacents = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        visited[row][column] = true;
        dfsChecker(visited, adjacents[0][0] + row, adjacents[0][1] + column, grid);
        dfsChecker(visited, adjacents[1][0] + row, adjacents[1][1] + column, grid);
        dfsChecker(visited, adjacents[2][0] + row, adjacents[2][1] + column, grid);
        dfsChecker(visited, adjacents[3][0] + row, adjacents[3][1] + column, grid);
      }
    }
  }

  @Test
  public void test1() {
    char[][] grid = {{'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
    System.out.println(numIslands(grid));
  }

}
