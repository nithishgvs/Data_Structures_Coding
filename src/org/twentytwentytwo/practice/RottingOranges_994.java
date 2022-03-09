package org.twentytwentytwo.practice;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class RottingOranges_994 {


  public int orangesRotting(int[][] grid) {

    int freshOranges = 0;

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          freshOranges++;
        }
        if (grid[i][j] == 2) {
          queue.add(new int[]{i, j});
        }
      }
    }

    if (freshOranges == 0) {
      return 0;
    }

    int time = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] polled = queue.poll();
        int[][] neighbours = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] neighbour : neighbours) {
          int row = polled[0] + neighbour[0];
          int col = polled[1] + neighbour[1];
          if (row > -1 && row < grid.length && col > -1 && col < grid[0].length) {
            if (grid[row][col] == 1) {
              freshOranges--;
              grid[row][col] = 2;
              queue.add(new int[]{row, col});
            }
          }
        }
      }

      time++;
      if (freshOranges == 0) {
        return time;
      }

    }

    return -1;

  }


  @Test
  public void test1() {
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}));
    System.out.println(orangesRotting(new int[][]{{0, 2}}));

  }


}
