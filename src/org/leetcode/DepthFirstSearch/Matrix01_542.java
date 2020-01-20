package org.leetcode.DepthFirstSearch;

import org.junit.Test;

public class Matrix01_542 {

//DFS TLE
  public int[][] updateMatrix(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] != 0) {
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          dfsHelper(i, j, matrix, 0);
        }
      }
    }

    return matrix;
  }

  private void dfsHelper(int i, int j, int[][] matrix, int currentValue) {
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
        || matrix[i][j] < currentValue) {
      return;
    }

    matrix[i][j] = currentValue;
    int[][] diagonals = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    for (int[] diagonal : diagonals) {
      dfsHelper(i + diagonal[0], j +diagonal[1], matrix, currentValue + 1);
    }
  }


  @Test
  public void test() {
    updateMatrix(new int[][]{{0, 0, 0},
        {0, 1, 0},
        {1, 1, 1}});
    System.out.println();
  }

}
