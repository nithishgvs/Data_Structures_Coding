package org.leetcode.DynamicProgramming;

import org.junit.Test;

public class ClimbingStairs_Google {

  public int climbStairs(int n) {
    int[] arr = new int[n + 1];
    arr[0] = 1;
    arr[1] = 1;

    for (int i = 2; i <= n; i++) {

      if (i - 5 >= 0) {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 5];
      } else {
        arr[i] = arr[i - 1] + arr[i - 2];
      }

    }

    return arr[n];
  }

  @Test
  public void testClimbStairs() {
    System.out.println(climbStairs(6));
  }

}
