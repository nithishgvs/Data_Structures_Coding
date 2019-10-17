package org.leetcode.BinarySearch;

import org.junit.Test;

public class SearchinRotatedSortedArray_33 {

  public int search(int[] nums, int target) {

    int h = nums.length - 1;

    if (nums.length == 1) {
      if (nums[0] == target) {
        return 0;
      } else {
        return -1;
      }
    }

    int pivot = findPivot(nums);

    if (pivot == -1) {
      return binarySearch(nums, 0, h, target);
    }

    if (target >= nums[0]) {
      return binarySearch(nums, 0, pivot - 1, target);
    } else {
      return binarySearch(nums, pivot, h, target);
    }
  }

  private int findPivot(int[] nums) {

    int l = 0, h = nums.length - 1;

    while (l <= h) {
      int mid = l + (h - l) / 2;

      if (mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]) {
        return mid + 1;
      }
      if (nums[mid] >= nums[l]) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }

    }
    return -1;
  }


  public int binarySearch(int[] nums, int l, int h, int target) {

    while (l <= h) {
      int mid = l + (h - l) / 2;

      if (target == nums[mid]) {
        return mid;
      } else if (target > nums[mid]) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return -1;
  }


  @Test
  public void test1() {
    System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
  }

  @Test
  public void test2() {
    System.out.println(search(new int[]{1, 3, 5}, 0));
  }

  @Test
  public void test3() {
    System.out.println(search(new int[]{3, 1}, 3));
  }


  @Test
  public void test4() {
    System.out.println(search(new int[]{3, 5, 1}, 3));
  }


  @Test
  public void test5() {
    System.out.println(search(new int[]{8, 9, 2, 3, 4}, 9));
  }


  @Test
  public void test6() {
    System.out.println(search(new int[]{1,3}, 0));
  }
}
