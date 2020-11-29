package org.leetcode.Arrays;

import org.junit.Test;

public class SumofAllOddLengthSubarrays_1588 {


  public int sumOddLengthSubarrays(int[] arr) {
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];

      for (int j = i - 2; j > -1; j = j - 2) {
        //add elements from j to i
        sum += addNumbers(arr, i, j);
      }

    }

    return sum;

  }

  private int addNumbers(int[] arr, int i, int j) {
    int sum = 0;
    for (int row = j; row <= i; row++) {
      sum += arr[row];
    }
    return sum;
  }


  @Test
  public void test1() {
    System.out.println(sumOddLengthSubarrays(new int[]{1, 2}));
  }
}
