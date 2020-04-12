package org.leetcode.Arrays;

import org.junit.Test;

public class SingleElementInaSortedArray_540 {

  public int singleNonDuplicate(int[] nums) {
    int output = 0;

    for (int i = 0; i < nums.length; i++) {
      output ^= nums[i];
    }

    return output;
  }


  @Test
  public void test() {
    System.out.println(singleNonDuplicate(new int[]{7,3,3,10,11,11,7}));
  }
}
