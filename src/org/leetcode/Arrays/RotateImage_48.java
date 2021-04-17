package org.leetcode.Arrays;

import org.junit.Test;

public class RotateImage_48 {

  public void rotate(int[][] matrix) {

    //first find transpose of a matrix

    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    //swap rows
    int n = matrix.length;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = temp;
      }
    }

    //System.out.println(matrix);
  }


  @Test
  public void testRotate() {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    rotate(matrix);
  }
}
