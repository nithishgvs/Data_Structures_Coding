package org.twentytwentytwo.practice;

public class MinimumFallingPathSum_931 {


  public int minFallingPathSum(int[][] matrix) {

    int minSum = Integer.MAX_VALUE;

    for (int i = matrix.length - 2; i > -1; i--) {
      for (int j = 0; j < matrix[0].length; j++) {
        int currentValue = matrix[i][j];
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;
        if (isValidBox(i + 1, j - 1, matrix)) {
          x = Math.min(x, matrix[i + 1][j - 1]);
        }
        if (isValidBox(i + 1, j, matrix)) {
          y = Math.min(y, matrix[i + 1][j]);
        }
        if (isValidBox(i + 1, j + 1, matrix)) {
          z = Math.min(z, matrix[i + 1][j + 1]);
        }

        matrix[i][j] = currentValue + Math.min(x, Math.min(y, z));
      }
    }

    for (int j = 0; j < matrix[0].length; j++) {
      minSum = Math.min(minSum, matrix[0][j]);
    }

    return minSum;

  }

  private boolean isValidBox(int row, int col, int[][] matrix) {

    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
      return false;
    }

    return true;
  }

}
