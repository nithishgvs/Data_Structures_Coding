package org.lcfresh.practice;

public class ReverseInteger_7 {

  public int reverse(int x) {
    double number = 0;
    if (x == 0) {
      return 0;
    }
    boolean negative = false;
    if (x < 0) {
      negative = true;
    }
    x = Math.abs(x);
    int length = (int) (Math.log10(x) + 1);

    while (x > 0) {
      int remainder = x % 10;
      number += remainder * Math.pow(10, length - 1);
      length--;
      x = x / 10;
    }

    int value = number > Integer.MAX_VALUE ? 0 : (int) number;
    return negative ? value * -1 : value;
  }

}
