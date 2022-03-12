package org.twentytwentytwo.practice;

import org.junit.Test;

public class Sqrt_69 {

  public int mySqrt(int x) {

    int l = 1;
    int h = x;

    while (l <= h) {
      long mid = l + (h - l) / 2;
      long value = mid * mid;
      if (value == x) {
        return (int) mid;
      } else if (value > x) {
        h = (int) mid - 1;
      } else {
        l = (int) mid + 1;
      }


    }

    return h;

  }


  @Test
  public void test() {
    System.out.println(mySqrt(2147395599));
    System.out.println(mySqrt(4));
    System.out.println(mySqrt(26));
  }
}
