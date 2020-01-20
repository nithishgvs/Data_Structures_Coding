package org.leetcode.DepthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class Matrix0_1_542 {


  public class Position {

    int r;
    int c;

    public Position(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public int[][] updateMatrix(int[][] matrix) {

    Queue<Position> queue = new ArrayDeque<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          queue.add(new Position(i, j));
        } else {
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    int[][] diagonals = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    while (!queue.isEmpty()) {
      Position position = queue.poll();
      for (int[] diagonal : diagonals) {
        int x = position.r + diagonal[0];
        int y = position.c + diagonal[1];

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
            || matrix[x][y] < matrix[position.r][position.c] + 1) {
          continue;
        }
        matrix[x][y] = matrix[position.r][position.c] + 1;
        queue.add(new Position(x, y));
      }
    }

    return matrix;
  }

  @Test
  public void test() {
    updateMatrix(new int[][]{{0, 0, 0},
        {0, 1, 0},
        {1, 1, 1}});
    System.out.println();
  }

  @Test
  public void test1() {
    updateMatrix(new int[][]{{0},{0},{0},{0},{0}});
    System.out.println();
  }

}
