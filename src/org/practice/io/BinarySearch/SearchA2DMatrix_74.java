package org.practice.io.BinarySearch;

import org.junit.Test;

public class SearchA2DMatrix_74 {

  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] subMatrix : matrix) {
      final int result = binarySearch(0, matrix[0].length - 1, subMatrix, target);
      if (result != -1) {
        return true;
      }
    }

    return false;
  }


  private int binarySearch(int firstIndex, int lastIndex, int[] array, int element) {
    while (firstIndex <= lastIndex) {
      int mid = firstIndex + (lastIndex - firstIndex) / 2;
      if (element == array[mid]) {
        return mid;
      } else if (element > array[mid]) {
        firstIndex = mid + 1;
      } else {
        lastIndex = mid - 1;
      }
    }

    return -1;
  }


  @Test
  public void test() {
    System.out
        .println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
  }
}
