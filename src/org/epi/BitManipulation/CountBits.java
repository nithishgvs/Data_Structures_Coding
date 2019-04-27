package org.epi.BitManipulation;

import org.junit.Test;

public class CountBits {

  public int countBits(int num) {
    int numBits = 0;
    while (num != 0) {
      numBits += (num & 1);
      num = num >>> 1;
      System.out.println(num);
    }
    return numBits;
  }

  @Test
  public void testBits(){
    System.out.println(countBits(2));
  }



}
