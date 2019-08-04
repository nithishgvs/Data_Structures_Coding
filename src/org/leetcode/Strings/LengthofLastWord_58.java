package org.leetcode.Strings;

import org.junit.Test;

public class LengthofLastWord_58 {


  public int lengthOfLastWord(String s) {
    s = s.trim();
    int length = 0;

    for (int i = s.length() - 1; i > -1; i--) {
      if (Character.isLetter(s.charAt(i))) {
        length++;
      } else {
        break;
      }
    }

    return length;
  }

  @Test
  public void test() {
    System.out.println(lengthOfLastWord(" Hello World "));
  }
}
