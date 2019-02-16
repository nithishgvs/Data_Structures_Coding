package org.leetcode.Math;

import java.util.Collections;
import org.junit.Test;

public class HammingDistance_461 {

  public int hammingDistance(int x, int y) {
    int hammingDistance = 0;
    String xString = Integer.toBinaryString(x);
    String yString = Integer.toBinaryString(y);
    if (xString.length() < yString.length()) {
      xString =
          String.join("", Collections.nCopies(yString.length() - xString.length(), "0")) + xString;
    } else {
      yString =
          String.join("", Collections.nCopies(xString.length() - yString.length(), "0")) + yString;
    }
    for (int i = 0; i < xString.length(); i++) {
      if (xString.charAt(i) != yString.charAt(i)) {
        hammingDistance++;
      }
    }
    return hammingDistance;
  }


  @Test
  public void test() {
    System.out.println(hammingDistance(128, 4));
  }


}
