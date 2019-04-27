package org.epi.BitManipulation;

import org.junit.Test;

public class NumberWeights {

  //Weight= no of bits set to 1

  public long closestIntSameBitCount(long x) {
    int NUM_UNSIGNED_BITS = 63;
    //x is assumed non-negative so the leading bit is 0 and we focus on 63 LSB's
    for (int i = 0; i < NUM_UNSIGNED_BITS - 1; ++i) {
      if ((((x >>> i) & 1) != ((x >>> (i + 1)) & 1))) {
        x ^= (1L << i) | (1L << (i + 1));
        break;
      }
    }
    return x;
  }


  @Test
  public void testClosestInt() {
    System.out.println(Long.toBinaryString(closestIntSameBitCount(8)));
  }
}
