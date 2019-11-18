package org.leetcode.Strings;

import org.junit.Test;

public class BinaryStringWithSubstringsRepresenting1ToN_1016 {

  public boolean queryString(String S, int N) {

    for (int i = 1; i <= N; i++) {

      String num = Integer.toBinaryString(i);
      if (S.indexOf(num) == -1) {
        return false;
      }
    }

    return true;

  }


  @Test
  public void test(){
    System.out.println(queryString("0110",4));
  }
}
