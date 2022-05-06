package org.twentytwentytwo.practice;

public class MaximumDifferenceBetweenIncreasingElements_2016 {


  public static int maximumDifference(int[] nums) {
    int min = nums[0];
    int diff = Integer.MIN_VALUE;

    for (int i = 1; i < nums.length; i++) {
      min = Math.min(min, nums[i]);
      if (nums[i] > min) {
        diff = Math.max(diff, nums[i] - min);
      }
    }

    return diff == Integer.MIN_VALUE ? -1 : diff;

  }

}
