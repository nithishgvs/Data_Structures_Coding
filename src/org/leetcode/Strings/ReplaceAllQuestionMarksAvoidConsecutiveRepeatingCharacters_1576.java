package org.leetcode.Strings;

import org.junit.Test;

public class ReplaceAllQuestionMarksAvoidConsecutiveRepeatingCharacters_1576 {

  public String modifyString(String s) {
    char[] charArray = s.toCharArray();

    for (int i = 0; i < charArray.length; i++) {
      char ch = charArray[i];
      if (ch == '?') {
        int ascii1 = i - 1 >= 0 ? (int) charArray[i - 1] : 0;
        int ascii2 = i + 1 < s.length() ? (int) charArray[i + 1] : 0;
        int begin = 97;
        while (Math.abs(begin - ascii1) == 0 || Math.abs(ascii2 - begin) == 0) {
          begin = begin + 2;
        }
        charArray[i] = (char) begin;
      }
    }
    return String.valueOf(charArray);
  }

  @Test
  public void test() {
    System.out.println(modifyString("j?qg??b"));
  }


}
