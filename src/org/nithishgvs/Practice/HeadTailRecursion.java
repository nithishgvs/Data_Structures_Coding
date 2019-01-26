package org.nithishgvs.Practice;

import org.junit.Test;

public class HeadTailRecursion {


  public void tail(int n) {
    if (n == 1) {
      return;
    }
    System.out.println(n);
    tail(n - 1);
  }


  public void head(int n) {
    if (n == 1) {
      return;
    }
    head(n - 1);
    System.out.println(n);
  }


  @Test
  public void testRecursion() {
    head(3);
  }


}
