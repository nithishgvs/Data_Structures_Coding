package org.leetcode.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class ShortestPathinBinaryMatrix_1091 {


  public class Distance {

    int[] location;
    int distance;

    public Distance(int[] location, int distance) {
      this.location = location;
      this.distance = distance;
    }
  }


  int shortestPath = -1;

  public int shortestPathBinaryMatrix(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;
    if (grid[0][0] == 1) {
      return -1;
    }
    if (grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0) {
      return 1;
    }
    Queue<Distance> queue = new ArrayDeque<>();
    queue.add(new Distance(new int[]{0, 0}, 1));
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Distance distance = queue.poll();
        for (int[] dir : dirs) {
          int newRow = dir[0] + distance.location[0];
          int newCol = dir[1] + distance.location[1];
          if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length
              || grid[newRow][newCol] == 1 || grid[newRow][newCol] == -1) {
            continue;
          }
          if (newRow == rows - 1 && newCol == cols - 1) {
            return distance.distance + 1;
          }
          grid[newRow][newCol] = -1;
          int[] newArray = new int[]{newRow, newCol};
          int newDistance = distance.distance + 1;
          queue.add(new Distance(newArray, newDistance));
        }
      }
    }

    return shortestPath;
  }


  @Test
  public void test1() {
    System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));

  }


}
