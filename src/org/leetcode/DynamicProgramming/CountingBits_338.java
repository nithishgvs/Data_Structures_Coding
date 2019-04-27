package org.leetcode.DynamicProgramming;

import org.junit.Test;

//Checked solution ,bit manipulation stuff
public class CountingBits_338 {

  public int[] countBits(int num) {
    if (num == 0) {
      return new int[1];
    }
    int[] countingArray = new int[num + 1];
    countingArray[0] = 0;
    countingArray[1] = 1;
    for (int i = 2; i <= num; i++) {
      countingArray[i] = countingArray[i >> 1] + (i & 1);
    }

    return countingArray;
  }

  @Test
  public void testBits() {
    int i = 3;
    System.out.println(4 >> 1);
    System.out.println(i & 1);
    int[] arr = countBits(5);
    System.out.println(arr.length);
  }


}
