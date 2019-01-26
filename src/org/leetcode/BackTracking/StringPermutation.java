package org.leetcode.BackTracking;

import org.junit.Test;

public class StringPermutation {


  public void permuteString(String string) {
    permuteString(string, 0, string.length() - 1);
  }

  private void permuteString(String string, int index1, int index2) {

    if (index1 == index2) {
      System.out.println(string);
    }

    for (int i = index1; i <= index2; i++) {
      string = swapString(string, index1, i);
      permuteString(string, index1 + 1, index2);
      string = swapString(string, index1, i);
    }
  }

  private String swapString(String string, int i, int i1) {
    StringBuilder sb = new StringBuilder(string);
    char temp = string.charAt(i);
    sb.setCharAt(i, string.charAt(i1));
    sb.setCharAt(i1, temp);
    return sb.toString();
  }


  @Test
  public void testPerm() {
    permuteString("abc");
  }


}
