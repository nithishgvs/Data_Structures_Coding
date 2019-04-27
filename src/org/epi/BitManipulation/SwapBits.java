package org.epi.BitManipulation;

import org.junit.Test;

public class SwapBits {

  /**
   * Bitmask concept we need to find the bit in the i and j th positions and swap take 1(long
   * number) and left shift shift to i positions and same 1 with j positions Do or with both values
   * obtained u get a number with values 1 in both indices i and j do xor operation with the above
   * number with actual x value if the value at ith index was previously 1 xor with 1 becomes 0 and
   * 0 previous xor with 1 becomes 1 hence swapped with bit mask
   */
  public long swapBits(long x, int i, int j) {
    System.out.println(Long.toBinaryString(x));
    if (((x >>> i) & 1) != ((x >>> j) & 1)) {
      System.out.println("The bits differ");
      System.out.println(Long.toBinaryString(1L << i));
      System.out.println(Long.toBinaryString(1L << j));
      long bitmask = (1L << i) | (1L << j);
      System.out.println(Long.toBinaryString(bitmask));
      x ^= bitmask;
      System.out.println(Long.toBinaryString(x));
    }
    return x;
  }


  @Test
  public void testSwapBits() {
    System.out.println(Long.toBinaryString(swapBits(73, 1, 6)));
  }


}
