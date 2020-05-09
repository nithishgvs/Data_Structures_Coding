package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class CountSquareSubmatriceswithAllOnes_1277 {


  public int countSquares(int[][] matrix) {

    int maxValue = 0;
    //Row 0
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] != 0) {
        maxValue++;
      }
    }

    //Col 0
    for (int j = 1; j < matrix.length; j++) {
      if (matrix[j][0] != 0) {
        maxValue++;
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] != 0) {
          matrix[i][j] =
              Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j])) + 1;
          maxValue +=
              matrix[i][j];
        }
      }
    }

    return maxValue;

  }


  @Test
  public void test1() {
    int[][] matrix = {
        {0, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 1, 1, 1}
    };
    System.out.println(countSquares(matrix));
  }

  @Test
  public void test2() {
    int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}, {1, 1, 1}, {1, 1, 0}};
    System.out.println(countSquares(matrix));
  }

}
