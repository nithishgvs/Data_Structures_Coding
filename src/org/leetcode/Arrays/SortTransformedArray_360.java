package org.leetcode.Arrays;

import java.util.Arrays;
import org.junit.Test;

public class SortTransformedArray_360 {

  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = processFunction(nums[i], a, b, c);
    }
    Arrays.sort(nums);
    return nums;
  }

  private int processFunction(int num, int a, int b, int c) {
    return (int) (a * Math.pow(num, 2)) + (b * num) + c;
  }

  @Test
  public void test1(){
    int [] nums={-4,-2,2,4};
    System.out.println(sortTransformedArray(nums,-1,3,5));
  }

}
