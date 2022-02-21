package org.twentytwentytwo.practice;

import org.junit.Test;

public class JumpGame_55 {


  public boolean canJump(int[] nums) {

    int lastGoodIndexPosition = nums.length - 1;
    for (int i = nums.length - 1; i > -1; i--) {
      int temp = i + nums[i];
      if (temp >= lastGoodIndexPosition) {
        lastGoodIndexPosition = i;
      }
    }
    return lastGoodIndexPosition == 0;
  }


  @Test
  public void test1() {
    int[] nums = {2, 3, 1, 0, 4};
    System.out.println(canJump(nums));
  }
}
