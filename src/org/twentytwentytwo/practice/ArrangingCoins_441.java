package org.twentytwentytwo.practice;

import org.junit.Test;

public class ArrangingCoins_441 {

  /**
   * ax2+bx+c
   * -b+sqrt(b2-4ac)/2a
   * @param n
   * @return
   */
  public int arrangeCoins(int n) {

    return ( (int)Math.sqrt(1+(long)8*n)-1 )/2;

  }


  @Test
  public void test(){
    System.out.println(arrangeCoins(1804289383));
  }
}
