package org.leetcode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

//Siddarth Uber question
public class NumberOfDistinctIslands_694 {

  public int numDistinctIslands(int[][] grid) {

    boolean[][] visited = new boolean[grid.length][grid[0].length];
    Set<String> uniqueSet = new HashSet<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          visited[i][j] = true;
          List<Grid> gridArray = new ArrayList<>();
          gridArray.add(new Grid(i, j));
          StringBuilder route = new StringBuilder();
          gridDfsHelper(grid, visited, i, j, gridArray, route);
          if (!uniqueSet.contains(route.toString())) {
            uniqueSet.add(route.toString());
          }
        }
      }
    }

    return uniqueSet.size();

  }

  private void gridDfsHelper(int[][] grid, boolean[][] visited, int x, int y,
      List<Grid> gridArray, StringBuilder route) {
    int[][] gridChecker = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    for (int i = 0; i < gridChecker.length; i++) {
      int newX = gridChecker[i][0] + x;
      int newY = gridChecker[i][1] + y;
      if (newY > -1 && newX > -1 && newX < grid.length && newY < grid[0].length) {
        if (grid[newX][newY] == 1 && !visited[newX][newY]) {
          route.append("[" + gridChecker[i][0] + "," + gridChecker[i][1] + "]");
          gridArray.add(new Grid(newX, newY));
          visited[newX][newY] = true;
          gridDfsHelper(grid, visited, newX, newY, gridArray, route);
        } else {
          route.append("*");
        }
      } else {
        route.append("*");
      }
    }

  }


  public class Grid {

    int x;
    int y;

    public Grid(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

  @Test
  public void test() {
    int[][] grid = {{1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1}};
    System.out.println(numDistinctIslands(grid));
  }

  @Test
  public void test1() {
    int[][] grid = {{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}};
    System.out.println(numDistinctIslands(grid));
  }

  @Test
  public void test2() {
    int[][] grid = {
        {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1,
            1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
        {0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0,
            0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0,
            1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0},
        {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1,
            1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}};
    System.out.println(numDistinctIslands(grid));

  }

}
