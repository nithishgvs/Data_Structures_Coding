package org.practice.io.ArraysAndHashing;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class RottingOranges_994 {


  public int orangesRotting(int[][] grid) {

    int minutes = 0;
    int freshOranges = 0;

    Queue<int[]> queue = new ArrayDeque<>();

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

    while (!queue.isEmpty()) {
      minutes++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] popped = queue.poll();
        int[][] neighbours = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        for (int[] adjacent : neighbours) {
          int newRow = popped[0] + adjacent[0];
          int newCol = popped[1] + adjacent[1];
          if (newRow > -1 && newRow < grid.length && newCol > -1 && newCol < grid[0].length
              && grid[newRow][newCol] == 1) {
            freshOranges--;
            if (freshOranges == 0) {
              return minutes;
            }
            grid[newRow][newCol] = 2;
            queue.add(new int[]{newRow, newCol});
          }
        }
      }
    }

    return -1;

  }


  @Test
  public void test1() {
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}));
    System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
  }

}
