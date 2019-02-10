package org.leetcode.Math;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class CountNumbersWithUniqueDigits_357 {

  public int countNumbersWithUniqueDigits(int n) {

    int upperBound = new Double(Math.pow(10, n)).intValue();
    int dupCount = 0;

    for (int i = 11; i < upperBound; i++) {
      if (sameDigits(i)) {
        dupCount++;
      }
    }

    return upperBound - dupCount;
  }

  private boolean sameDigits(int i) {
    String number = String.valueOf(i);
    Set<Character> digitSet = new HashSet<>();
    for (Character ch : number.toCharArray()) {
      if(!digitSet.add(ch)){
        return true;
      }
    }

    return false;
  }

  @Test
  public void testUniqueDigits() {
    System.out.println(countNumbersWithUniqueDigits(3));
  }

}
