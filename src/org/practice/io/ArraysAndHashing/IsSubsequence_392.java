package org.practice.io.ArraysAndHashing;

import org.junit.Test;

public class IsSubsequence_392 {

  public boolean isSubsequence(String s, String t) {

    int index = 0;
    for (int i = 0; i < t.length(); i++) {
      if (index == s.length()) {
        break;
      }
      if (t.charAt(i) == s.charAt(index)) {
        index++;
      }
    }

    return s.length() == index;
  }

  @Test
  public void test() {
    //System.out.println(isSubsequence("abc", "ahbgdc"));
    System.out.println(isSubsequence("axc", "ahbgdc"));
  }

}
