package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SpiralMatrix_54 {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();

    if (matrix.length == 0 || matrix == null) {
      return list;
    }

    int left = 0;
    int right = matrix[0].length - 1;
    int bottom = matrix.length - 1;
    int top = 0;

    int size = matrix.length * matrix[0].length;

    while (list.size() < size) {

      for (int i = left; i <= right && list.size() < size; i++) {
        list.add(matrix[top][i]);
      }
      top++;
      for (int i = top; i <= bottom && list.size() < size; i++) {
        list.add(matrix[i][right]);
      }
      right--;

      for (int i = right; i >= left && list.size() < size; i--) {
        list.add(matrix[bottom][i]);
      }
      bottom--;

      for (int i = bottom; i >= top && list.size() < size; i--) {
        list.add(matrix[i][left]);
      }
      left++;
    }

    return list;

  }


  @Test
  public void test() {
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    spiralOrder(matrix);
    System.out.println(Character.MIN_VALUE);
  }
}
