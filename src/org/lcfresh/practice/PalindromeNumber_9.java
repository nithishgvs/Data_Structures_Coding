package org.lcfresh.practice;

public class PalindromeNumber_9 {

  public boolean isPalindrome(int x) {
    if (x < 0 || x == Integer.MAX_VALUE) {
      return false;
    }

    int original = x;
    int digits = (int) (Math.log10(x) + 1);

    double number = 0;

    while (x > 0) {
      int remainder = x % 10;
      number += remainder * (Math.pow(10, digits - 1));
      digits--;
      x = x / 10;
    }

    return original == (int) number;

  }

}
