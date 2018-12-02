package org.leetcode.DynamicProgramming;

import java.util.Arrays;
import org.junit.Test;

public class LongestIncreasingSubsequence_300 {


  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] lengthsArray = new int[nums.length];
    Arrays.fill(lengthsArray, 1);


    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          if (lengthsArray[i] < lengthsArray[j] + 1) {
            lengthsArray[i] = lengthsArray[j] + 1;
          }

        }
      }

    }
    return Arrays.stream(lengthsArray).max().getAsInt();
  }


  @Test
  public void testLengthofLIS1() {
    int[] nums = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
    System.out.println(lengthOfLIS(nums));
  }

  @Test
  public void testLengthofLIS2() {
    int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
    System.out.println(lengthOfLIS(nums));
  }
}
