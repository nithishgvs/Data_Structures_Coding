package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class MinimumFallingPathSum_931 {

  public int minFallingPathSum(int[][] matrix) {

    int value = Integer.MAX_VALUE;

    for (int i = matrix.length - 2; i > -1; i--) {
      for (int j = 0; j < matrix[0].length; j++) {
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
        if (valid(i + 1, j - 1, matrix)) {
          x = matrix[i + 1][j - 1];
        }
        if (valid(i + 1, j, matrix)) {
          y = matrix[i + 1][j];
        }
        if (valid(i + 1, j + 1, matrix)) {
          z = matrix[i + 1][j + 1];
        }

        matrix[i][j] += Math.min(x, Math.min(y, z));
      }

    }

    for (int i = 0; i < matrix[0].length; i++) {
      value = Math.min(value, matrix[0][i]);
    }

    return value;

  }

  private boolean valid(int row, int col, int[][] matrix) {

    if (row > -1 && row < matrix.length && col > -1 && col < matrix[0].length) {
      return true;
    }

    return false;
  }


  @Test
  public void test1() {
    int[][] matrix = {{-19,57},{-40,-5}};
    System.out.println(minFallingPathSum(matrix));
  }
}
