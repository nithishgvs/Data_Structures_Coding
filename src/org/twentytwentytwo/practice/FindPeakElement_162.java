package org.twentytwentytwo.practice;

import org.junit.Test;

public class FindPeakElement_162 {


  public int findPeakElement(int[] nums) {

    int l = 0;
    int h = nums.length - 1;

    while (l < h) {

      int mid = l + (h - l) / 2;

      int midPlusOne = mid + 1;

      if (nums[mid] > nums[midPlusOne]) {
        h = mid;
      } else if (nums[mid] < nums[midPlusOne]) {
        l = midPlusOne;
      }

    }

    return l;
  }


  @Test
  public void test() {
    int[] nums = {1, 2, 3, 1};
    System.out.println(findPeakElement(nums));
  }
}
