package org.leetcode.Arrays;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class RottingOranges_994 {

  Queue<OrangeNode> queue = new LinkedList<>();

  boolean[][] visited = null;

  public int orangesRotting(int[][] grid) {
    int level = 0;
    visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          //starts
          queue.add(new OrangeNode(i, j, -1));
        }
      }
    }

    while (!queue.isEmpty()) {
      OrangeNode orangeNode = queue.poll();
      level = orangeNode.level + 1;
      checkDiagonals(orangeNode.x - 1, orangeNode.y, grid, level, visited);
      checkDiagonals(orangeNode.x + 1, orangeNode.y, grid, level, visited);
      checkDiagonals(orangeNode.x, orangeNode.y - 1, grid, level, visited);
      checkDiagonals(orangeNode.x, orangeNode.y + 1, grid, level, visited);
    }

    if (checkForOrphan(visited, grid)) {
      return -1;
    }

    return level;

  }

  private boolean checkForOrphan(boolean[][] visited, int[][] grid) {

    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited[0].length; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          return true;
        }
      }
    }
    return false;
  }


  private void checkDiagonals(int i, int j, int[][] grid, int level, boolean[][] visited) {
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
        && grid[i][j] == 1 && !visited[i][j]) {
      queue.add(new OrangeNode(i, j, level));
      visited[i][j] = true;
    }
  }

  public class OrangeNode {

    int x;
    int y;
    int level;

    public OrangeNode(int x, int y, int level) {
      this.x = x;
      this.y = y;
      this.level = level;
    }
  }


  @Test
  public void testRotting1() {
    int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    System.out.println(orangesRotting(grid));

  }

  @Test
  public void testRotting2() {
    int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println(orangesRotting(grid));

  }

  @Test
  public void testRotting3() {
    int[][] grid = {{0, 2}};
    System.out.println(orangesRotting(grid));

  }

  @Test
  public void testRotting4() {
    int[][] grid = {{1}, {1}, {1}, {1}};
    System.out.println(orangesRotting(grid));

  }

  @Test
  public void testRotting5() {
    int[][] grid = {{1, 1, 2, 0, 2, 0}};
    System.out.println(orangesRotting(grid));

  }

  @Test
  public void testRotting6() {
    int[][] grid = {{2,2,2,1,1}};
    System.out.println(orangesRotting(grid));

  }


}
