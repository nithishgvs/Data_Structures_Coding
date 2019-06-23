package org.leetcode.DynamicProgramming;

public class RangeSumQuery2D_Immutable_304 {


  int[][] matrix;


  public RangeSumQuery2D_Immutable_304(int[][] matrix) {
    this.matrix = matrix;
    int sum = 0;

    if (matrix.length == 0) {
      return;
    }

    for (int i = 1; i < matrix[0].length; i++) {
      matrix[0][i] += matrix[0][i - 1];
    }

    for (int i = 1; i < matrix.length; i++) {
      matrix[i][0] += matrix[i - 1][0];
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
      }
    }


  }


  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (matrix.length == 0) {
      return 0;
    }
    int sum = matrix[row2][col2];
    if (row1 - 1 >= 0) {
      sum -= matrix[row1 - 1][col2];
    }
    if (col1 - 1 >= 0) {
      sum -= matrix[row2][col1 - 1];
    }

    if (row1 - 1 >= 0 && col1 - 1 >= 0) {
      sum += matrix[row1 - 1][col1 - 1];
    }
    return sum;
  }

  public static void main(String[] args) {
    RangeSumQuery2D_Immutable_304 rangeSumQuery2D_immutable_304 = new RangeSumQuery2D_Immutable_304(
        new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        });
    System.out.println(rangeSumQuery2D_immutable_304.sumRegion(2, 1, 4, 3));

  }


}
