package org.leetcode.Math;

import org.junit.Test;

public class PalindromeNumber_9 {

  public boolean isPalindrome(int x) {

    if (x < 0 || x == Integer.MAX_VALUE) {
      return false;
    }

    double number = x;

    int y = x;

    int totalDigits = 0;

    while (number >= 1) {
      number = number / 10;
      totalDigits++;
    }

    boolean flag = false;
    number = 0;

    while (x != 0) {
      if (!flag && x % 10 == 0) {
        return false;
      }
      flag = true;
      number += (x % 10) * Math.pow(10, --totalDigits);
      x = x / 10;
    }

    return ((int) number == y);

  }


  @Test
  public void test1() {
    System.out.println(isPalindrome(110));
    System.out.println(isPalindrome(2147483647));
  }

}
