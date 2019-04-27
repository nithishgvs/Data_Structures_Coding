package org.epi.BitManipulation;

import org.junit.Test;

public class ParityChecker {

  public short parityChecker1(long num) {
    short result = 0;

    while (num != 0) {
      result ^= num & 1;
      num = num >>> 1;
      System.out.println(num);
    }

    return result;
  }


  public short parityChecker2(long num) {
    short result = 0;

    while (num != 0) {
      result ^= 1;
      System.out.println(Long.toBinaryString(num) + " " + Long.toBinaryString(num - 1));
      //lowest set bit gets erased here number &(number-1)
      num &= (num - 1);
      System.out.println(num);
      System.out.println(Long.toBinaryString(num));
    }

    return result;
  }

  public int parityChecker3(int num) {
    System.out.println(Integer.toBinaryString(num));
    //System.out.println(Integer.toBinaryString(num >>> 16));
    //System.out.println(Integer.toBinaryString(num >>> 8));
    System.out.println(Integer.toBinaryString(num >>> 4));
    System.out.println(Integer.toBinaryString(num >>> 2));
    System.out.println(Integer.toBinaryString(num >>> 1));
    num ^= num >>> 4;
    num ^= num >> 2;
    num ^= num >>> 1;
    //The last bit is the result so and(&) with 1 gives last bit
    return (int) (num & 1);
  }

  @Test
  public void testParityChecker1() {
    System.out.println(Integer.toBinaryString(0x1));
    System.out.println(parityChecker3(4));
  }


}
