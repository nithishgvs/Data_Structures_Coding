package org.nithishgvs.Practice;

import org.junit.Test;

public class FactorialGcd {


  public int factorial(int n) {
    if (n == 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }


  public int gcd(int n1, int n2) {

    if (n2 == 0) {
      return n1;
    }

    return gcd(n2, n1 % n2);

  }


  @Test
  public void testFactorial() {
    System.out.println(factorial(4));
  }

  @Test
  public void testGcd() {
    System.out.println(gcd(3768, 1701));
  }

}
