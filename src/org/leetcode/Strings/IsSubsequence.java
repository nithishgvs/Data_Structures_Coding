package org.leetcode.Strings;

import org.junit.Test;

public class IsSubsequence {

  public boolean isSubsequence(String s, String t) {

    if (s.length() == 0 || (s.length() == 0 && t.length() == 0)) {
      return true;
    }

    int sPtr = 0, tPtr = 0;

    while (tPtr < t.length()) {
      if (s.charAt(sPtr) == t.charAt(tPtr)) {
        sPtr++;
      }
      if (sPtr == s.length()) {
        return true;
      }
      tPtr++;
    }

    return false;
  }

  @Test
  public void test1() {
    System.out.println(isSubsequence("abc", "ahbgdc"));
    System.out.println(isSubsequence("axc", "ahbgdc"));
    System.out.println(isSubsequence("b", "abc"));
  }

}
