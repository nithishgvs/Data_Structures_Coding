package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class MaximalSquare_221 {


  public int maximalSquare(char[][] matrix) {

    if (matrix.length == 0) {
      return 0;
    }

    int maxValue = 0;

    int[][] dp = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          if (i >= 1 && j >= 1) {
            dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
          } else {
            dp[i][j] = 1;
          }
          maxValue = Math.max(maxValue, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }

    return maxValue * maxValue;

  }


  @Test
  public void test1() {
    char[][] arr = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
        {'1', '0', '1', '1', '1'}};
    System.out.println(maximalSquare(arr));

  }

  @Test
  public void test2() {
    char[][] arr = {{'0'}, {'1'}};
    System.out.println(maximalSquare(arr));

  }


  @Test
  public void test3() {
    char[][] matrix = {{'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'1', '1', '1', '1'}};
    System.out.println(maximalSquare(matrix));
  }
}
