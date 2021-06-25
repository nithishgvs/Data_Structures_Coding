package org.leetcode.Arrays;

public class MinimumMovestoEqualArrayElements_453 {
  public int minMoves(int[] nums) {
    int moves=0;
    int min=Integer.MAX_VALUE;

    for(int i:nums){
      min=Math.min(min,i);
    }

    for(int i:nums){
      moves+=i-min;
    }
    return moves;

  }

}
