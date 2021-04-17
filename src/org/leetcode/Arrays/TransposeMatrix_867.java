package org.leetcode.Arrays;

import org.junit.Test;

public class TransposeMatrix_867 {

  public int[][] transpose(int[][] matrix) {
    int[][] result = new int[matrix[0].length][matrix.length];

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = matrix[j][i];
      }
    }
    return result;
  }

  @Test
  public void test1(){
    int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
    System.out.println(transpose(matrix));
  }

}
