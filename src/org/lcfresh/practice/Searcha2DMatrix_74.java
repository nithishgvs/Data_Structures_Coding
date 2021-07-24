package org.lcfresh.practice;

import org.junit.Test;

public class Searcha2DMatrix_74 {

  public boolean searchMatrix(int[][] matrix, int target) {

    for (int[] subMatrix : matrix) {
      if (binarySearchHelper(subMatrix, target) != -1) {
        return true;
      }
    }

    return false;

  }

  private int binarySearchHelper(int[] subMatrix, int target) {

    int l = 0;
    int h = subMatrix.length - 1;

    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (subMatrix[mid] == target) {
        return mid;
      } else if (subMatrix[mid] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return -1;
  }

  @Test
  public void test1() {
    System.out.println(searchMatrix(new int[][]{
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    }, 34));
  }


  @Test
  public void test2() {
    System.out.println(searchMatrix(new int[][]{
            {1}}
        , 1));
  }

}
