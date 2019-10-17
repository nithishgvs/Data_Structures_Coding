package org.leetcode.BinarySearch;

import org.junit.Test;

public class SearchinRotatedSortedArrayII_81 {

  public boolean search(int[] nums, int target) {

    if (nums.length == 1) {
      if (nums[0] == target) {
        return true;
      } else {
        return false;
      }
    }

    int pivot = findPivot(nums);

    if (pivot == -1) {
      return binarySearch(nums, 0, nums.length - 1, target);
    }

    if (nums[0] <= target && nums[pivot] >= target) {
      return binarySearch(nums, 0, pivot, target);
    } else {
      return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }
  }


  private int findPivot(int[] nums) {

    int l = 0, h = nums.length - 1;

    while (l <= h) {

      int mid = l + (h - l) / 2;

      if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
        return mid;
      }

      if (nums[l] < nums[mid] || (nums[l] == nums[mid] && l == mid)) {
        l = mid + 1;
      } else if (nums[l] == nums[mid]) {
        if (mid - 1 > -1 && nums[mid - 1] <= nums[mid]) {
          l = mid + 1;
        } else {
          h = mid - 1;
        }
      } else {
        h = mid - 1;
      }

    }

    return -1;
  }

  public boolean binarySearch(int[] nums, int l, int h, int target) {

    while (l <= h) {
      int mid = l + (h - l) / 2;

      if (target == nums[mid]) {
        return true;
      } else if (target > nums[mid]) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return false;
  }


  @Test
  public void test1() {
    System.out.println(search(new int[]{8, 9, 2, 3, 4}, 9));
  }

  @Test
  public void test2() {
    System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
  }

  @Test
  public void test3() {
    System.out.println(search(new int[]{3, 1}, 2));
  }

  @Test
  public void test4() {
    System.out.println(search(new int[]{1, 3, 1, 1, 1}, 3));
  }

  @Test
  public void test5() {
    System.out.println(search(new int[]{2, 2, 2, 3, 1}, 1));
  }
}
