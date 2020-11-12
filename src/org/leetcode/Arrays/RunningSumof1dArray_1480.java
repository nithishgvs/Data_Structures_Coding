package org.leetcode.Arrays;

import org.junit.Test;

public class RunningSumof1dArray_1480 {

  public int[] runningSum(int[] nums) {
    for(int i=1;i<nums.length;i++){
      nums[i]=nums[i]+nums[i-1];
    }
    return nums;
  }

  @Test
  public void test1(){
    int [] nums={1,1,1,1,1};
    System.out.println(runningSum(nums));
  }

}
