package org.leetcode.SearchingSorting;

import org.junit.Test;

public class Searcha2DMatrix_74 {

  public boolean searchMatrix(int[][] matrix, int target) {

    if (matrix.length < 0) {
      return false;
    }

    for (int[] arr : matrix) {
      if (arr.length > 0 && arr[0] <= target && arr[arr.length - 1] >= target) {
        if (binarySearchHelper(arr, target)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean binarySearchHelper(int[] arr, int target) {

    int l = 0, h = arr.length - 1;

    while (l <= h) {

      int mid = (h - l) / 2 + l;

      if (arr[mid] == target) {
        return true;
      } else if (arr[mid] > target) {
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
