package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class MaximumLengthofRepeatedSubarray_718 {

  public int findLength(int[] A, int[] B) {
    int max = 0;

    int[][] dp = new int[A.length][B.length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        if (A[i] == B[j]) {
          if (i - 1 >= 0 && j - 1 >= 0) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
          } else {
            dp[i][j] = 1;
          }
        }
        max = Math.max(max, dp[i][j]);
      }
    }

    return max;
  }


  @Test
  public void test1() {
    System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
  }


}
