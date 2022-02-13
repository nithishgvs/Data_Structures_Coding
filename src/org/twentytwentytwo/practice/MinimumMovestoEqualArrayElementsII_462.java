package org.twentytwentytwo.practice;

import java.util.Arrays;
import org.junit.Test;

public class MinimumMovestoEqualArrayElementsII_462 {

  public int minMoves2(int[] nums) {
    int moves = 0;
    Arrays.sort(nums);
    int median;
    int mid = nums.length / 2;
    if (nums.length % 2 != 0) {
      median = nums[mid];
    } else {
      median = (nums[mid] + nums[mid - 1]) / 2;
    }

    for (int num : nums) {
      moves += Math.abs(num - median);
    }

    return moves;

  }

  @Test
  public void test1() {
    int[] nums = {1};
    System.out.println(minMoves2(nums));
  }

}
