package org.lcfresh.practice;

import org.junit.Test;

public class FindtheDuplicateNumber_287 {


  public int findDuplicate(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      if (nums[Math.abs(nums[i])] > 0) {
        nums[Math.abs(nums[i])] = nums[Math.abs(nums[i])] * -1;
      } else {
        return Math.abs(nums[i]);
      }
    }

    return -1;
  }


  @Test
  public void testDuplicate() {
    System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
  }
}
