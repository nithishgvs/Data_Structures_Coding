package org.leetcode.SearchingSorting;

import org.junit.Test;

public class Searcha2DMatrixII_240 {

  public boolean searchMatrix(int[][] matrix, int target) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; i++) {
        boolean rowVal = false;
        boolean colVal = false;
        if (matrix[i][j] <= target && matrix[i][matrix[0].length - 1] >= target) {
          rowVal = binaryRowHelper(i, i, matrix[0].length - 1, matrix, target);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] <= target
            && matrix[matrix.length - 1][i] >= target) {
          colVal = binaryColHelper(j, i + 1, matrix.length - 1, matrix, target);
        }
        if (rowVal || colVal) {
          return true;
        }
        break;
      }


    }

    return false;
  }

  private boolean binaryColHelper(int col, int index1, int index2, int[][] matrix, int target) {

    int l = index1, h = index2;

    while (l <= h) {

      int mid = (h - l) / 2 + l;

      if (matrix[mid][col] == target) {
        return true;
      } else if (matrix[mid][col] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }

    }

    return false;

  }

  private boolean binaryRowHelper(int row, int index1, int index2, int[][] matrix, int target) {
    int l = index1, h = index2;

    while (l <= h) {

      int mid = (h - l) / 2 + l;

      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }

    }

    return false;
  }


  @Test
  public void test1() {
    System.out.println(searchMatrix(new int[][]{
        {1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    }, 30));
  }

  @Test
  public void test2() {
    System.out.println(searchMatrix(new int[][]{
        {1},
        {3},
        {5}
    }, 1));
  }


}
