package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class SpiralMatrix_54 {


  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> output = new ArrayList<>();
    if (matrix.length == 0) {
      return output;
    }

    int i = 0, j = 0;

    int R = matrix.length, C = matrix[0].length;
    int R_ = 1, C_ = 0;

    while (true) {
      for (; j < C; j++) {
        output.add(matrix[i][j]);
        if (checkSize(matrix, output)) {
          return output;
        }
      }
      C--;
      j--;
      i++;
      for (; i < R; i++) {
        output.add(matrix[i][j]);
        if (checkSize(matrix, output)) {
          return output;
        }
      }
      R--;
      i = i - 1;
      j = j - 1;

      for (; j >= C_; j--) {
        output.add(matrix[i][j]);
        if (checkSize(matrix, output)) {
          return output;
        }
      }
      C_ = C_ + 1;
      j = j + 1;
      i = i - 1;

      for (; i >= R_; i--) {
        output.add(matrix[i][j]);
        if (checkSize(matrix, output)) {
          return output;
        }
      }
      R_ = R_ + 1;
      i = i + 1;
      j = j + 1;


    }

  }

  private boolean checkSize(int[][] matrix, List<Integer> output) {
    if (output.size() == matrix.length * matrix[0].length) {
      return true;
    }
    return false;
  }

  @Test
  public void testSpiralOrder() {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
  }

  @Test
  public void testSpiral2() {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
  }

  @Test
  public void testSpiral3() {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };

    System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
  }

  @Test
  public void testSpiral4() {
    int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}};

    System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
  }


}
