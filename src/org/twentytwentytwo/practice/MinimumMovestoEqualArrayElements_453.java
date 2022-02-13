package org.twentytwentytwo.practice;

import org.junit.Test;

public class MinimumMovestoEqualArrayElements_453 {


  public int minMoves(int[] nums) {
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      min = Math.min(min, num);
    }
    int moves = 0;
    for (int num : nums) {
      moves += num - min;
    }
    return moves;
  }


  @Test
  public void test1() {
    int[] nums = {1, 2, 3};
    System.out.println(minMoves(nums));
  }
}
