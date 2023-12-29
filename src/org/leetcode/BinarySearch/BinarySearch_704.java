package org.leetcode.BinarySearch;

import org.junit.Test;

public class BinarySearch_704 {

  public int search(int[] nums, int target) {
    int l = 0;
    int h = nums.length - 1;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return -1;

  }


  @Test
  public void test() {
    int[] nums = {-1, 0, 3, 5, 9, 12};
    System.out.println(search(nums, 2));
  }
}
