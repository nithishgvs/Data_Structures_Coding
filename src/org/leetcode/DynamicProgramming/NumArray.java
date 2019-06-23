package org.leetcode.DynamicProgramming;

//RangeSumQuery_Immutable_303
public class NumArray {


  int[] sums;

  NumArray(int[] nums) {
    sums = nums;
    for (int i = 1; i < nums.length; i++) {
      sums[i] += sums[i-1];
    }
  }

  public int sumRange(int i, int j) {
    return sums[j] - (i == 0 ? 0 : sums[i-1]);
  }

  public static void main(String[] args) {
    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    System.out.println(numArray.sumRange(0, 5));
  }


}
