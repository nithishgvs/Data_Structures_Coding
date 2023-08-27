package org.practice.io.Strings;

import org.junit.Test;

public class LengthOfLastWord_58 {

  public int lengthOfLastWord(String s) {
    String[] strings = s.trim().split("\\s+");
    return strings[strings.length - 1].length();
  }


  @Test
  public void test() {
    System.out.println(lengthOfLastWord("a"));
  }
}

