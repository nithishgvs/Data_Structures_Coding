package org.leetcode.Arrays;

import org.junit.Test;

public class ProductOfArrayExceptSelf_238 {


  public int[] productExceptSelf(int[] nums) {
    int temp = 1;

    int l = 0, h = nums.length - 1;

    int secondTemp = 1;

    int thirdTemp = 1;

    while (l <= h) {

      if (h == l) {
        h = nums.length - 1;
        thirdTemp = temp * secondTemp;
        secondTemp = nums[l];
        nums[l] = thirdTemp;
        temp = temp * secondTemp;
        secondTemp = 1;
        l++;
        continue;
      }
      secondTemp = secondTemp * nums[h];
      h--;

    }

    return nums;
  }


  @Test
  public void testProductExceptSelf() {
    int[] nums = {1, 2, 3, 4};
    productExceptSelf(nums);
  }


  @Test
  public void testProductExceptSelf1() {
    int[] nums = {1, 2, 3, 4, 5};
    productExceptSelf(nums);
  }


}
