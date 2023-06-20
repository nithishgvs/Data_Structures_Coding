package org.practice.io.BinarySearch;

import org.junit.Test;

public class SearchInsertPosition_35 {


  public int searchInsert(int[] nums, int target) {

    return binarySearch(0, nums.length - 1, nums, target);

  }

  private int binarySearch(int firstIndex, int lastIndex, int[] array, int element) {
    while (firstIndex <= lastIndex) {
      int mid = firstIndex + (lastIndex - firstIndex) / 2;
      if (element == array[mid]) {
        return mid;
      } else if (element > array[mid]) {
        firstIndex = mid + 1;
        return recursiveBinarySearch(firstIndex, lastIndex, array, element);
      } else {
        lastIndex = mid - 1;
        return recursiveBinarySearch(firstIndex, lastIndex, array, element);
      }
    }

    return -1;
  }

  private int recursiveBinarySearch(int firstIndex, int lastIndex, int[] array, int element) {
    final int newIndex = binarySearch(firstIndex, lastIndex, array, element);
    if (newIndex == -1) {
      if (lastIndex == -1) {
        return 0;
      } else if (element > array[lastIndex]) {
        return lastIndex + 1;
      } else {
        return firstIndex + 1;
      }
    }
    return newIndex;
  }

  @Test
  public void test1() {
    //System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 4));
    //System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
  }

}
