package org.leetcode.Math;

import org.junit.Test;

public class FirstMissingPositive_41 {

  public int firstMissingPositive(int[] nums) {
    boolean oneFound = false;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        oneFound = true;
      }
      if (nums[i] <= 0 || nums[i] > nums.length) {
        nums[i] = 1;
      }
    }
    if (!oneFound) {
      return 1;
    }

    for (int i = 0; i < nums.length; i++) {
      int curr = Math.abs(nums[i]);
      if (curr <= nums.length && nums[curr - 1] > 0) {
        nums[curr - 1] = -1 * Math.abs(nums[curr - 1]);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }

    return nums.length + 1;
  }


  @Test
  public void test() {
    int[] nums = {7, 8, 9, 11, 12};
    System.out.println(firstMissingPositive(nums));
  }

  @Test
  public void test1() {
    int[] nums = {3, 4, -1, 1};
    System.out.println(firstMissingPositive(nums));
  }

  @Test
  public void test2() {
    int[] nums = {1};
    System.out.println(firstMissingPositive(nums));
  }

}
