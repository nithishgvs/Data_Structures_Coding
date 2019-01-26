package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class NumberofLongestIncreasingSubsequence_673 {

  public int findNumberOfLIS(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }
    int[] lengthsArray = new int[nums.length];
    int maxLis = 1;
    int maxListCurrent = 1;
    lengthsArray[0] = 1;
    int count = 0;
    int finalRoundcount = 0;

    for (int i = 1; i < nums.length; i++) {
      lengthsArray[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          if (lengthsArray[i] <= lengthsArray[j] + 1) {
            lengthsArray[i] = lengthsArray[j] + 1;
            maxLis = Math.max(maxLis, lengthsArray[i]);
            if (maxLis > maxListCurrent) {
              maxListCurrent = maxLis;
              count = 1;
            } else if (maxLis == maxListCurrent && (count != 0)) {
              count++;
            }

          }
        }

      }
      if (count > 0) {
        finalRoundcount = count;
      }
      count = 0;
    }
    return finalRoundcount;
  }

  @Test
  public void testLengthofLIS1() {
    int[] nums = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
    System.out.println(findNumberOfLIS(nums));
  }

  @Test
  public void testLengthofLIS2() {
    int[] nums = {1, 3, 5, 4, 7};
    System.out.println(findNumberOfLIS(nums));
  }

  @Test
  public void testLengthofLIS3() {
    int[] nums = {2, 2, 2, 2, 2};
    System.out.println(findNumberOfLIS(nums));
  }


  @Test
  public void testLengthofLIS4() {
    int[] nums = {4, 6, 7, 7};
    System.out.println(findNumberOfLIS(nums));
  }

  @Test
  public void testLengthofLIS5() {
    int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
    System.out.println(findNumberOfLIS(nums));
  }


}
