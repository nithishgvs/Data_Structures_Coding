package org.lcfresh.practice;

import org.junit.Test;

public class NextPermutation_31 {
  //https://www.youtube.com/watch?v=quAS1iydq7U

  public void nextPermutation(int[] nums) {
    int index = nums.length - 2;

    while (index >= 0 && nums[index + 1] <= nums[index]) {
      index--;
    }

    if (index >= 0) {

      int index2 = nums.length - 1;

      while (index2 >= 0 && nums[index] >= nums[index2]) {
        index2--;
      }

      swap(index, index2, nums);

    }

    reverse(nums, index + 1);

  }

  private void reverse(int[] nums, int index) {
    int end = nums.length - 1;
    while (index < end) {
      swap(index, end, nums);
      end--;
      index++;
    }
  }

  private void swap(int index1, int index2, int[] nums) {
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }

  @Test
  public void test1() {
    int[] nums = {1, 2, 3, 4};

    nextPermutation(nums);
  }


}
