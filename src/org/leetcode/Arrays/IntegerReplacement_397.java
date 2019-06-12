package org.leetcode.Arrays;

import org.junit.Test;

public class IntegerReplacement_397 {

  public int integerReplacement(int n) {
    if (n == 1) {
      return 0;
    }
    if (n % 2 == 0) {
      return 1 + integerReplacement(n / 2);
    } else {
      if (n == Integer.MAX_VALUE) {
        return integerReplacement(n - 1);
      } else {
        return 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
      }
    }

  }


  @Test
  public void integerReplacementTest() {
    System.out.println(integerReplacement(2147483647));
    System.out.println(Integer.MAX_VALUE % 2);
  }

}
