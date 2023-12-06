package org.lcfresh.practice;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class ShortestPathinBinaryMatrix_1091 {


  class Path {

    int x, y, distance;

    public Path(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }


  public int shortestPathBinaryMatrix(int[][] grid) {
    int minPath = Integer.MAX_VALUE;

    Queue<Path> queue = new LinkedList<>();

    if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
      return -1;
    }

    queue.add(new Path(0, 0, 1));

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    int[][] neighbours = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    while (!queue.isEmpty()) {
      Path path = queue.poll();

      if (!visited[path.x][path.y]) {
        for (int[] neighbour : neighbours) {
          if (path.x == grid.length - 1 && path.y == grid[0].length - 1) {
            return path.distance;
          }
          int x = path.x + neighbour[0];
          int y = path.y + neighbour[1];
          if (validPath(x, y, grid)) {
            queue.add(new Path(x, y, path.distance + 1));
          }
          visited[path.x][path.y] = true;
        }
      }
    }

    return minPath == Integer.MAX_VALUE ? -1 : minPath;

  }

  private boolean validPath(int x, int y, int[][] grid) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 0) {
      return false;
    }
    return true;
  }

  @Test
  public void test1() {
    int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
    System.out.println(shortestPathBinaryMatrix(grid));
  }

  @Test
  public void test2() {
    int[][] grid = {{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0},
        {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}};
    System.out.println(shortestPathBinaryMatrix(grid));
  }
}
