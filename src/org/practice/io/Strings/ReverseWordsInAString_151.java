package org.practice.io.Strings;

import org.junit.Test;

public class ReverseWordsInAString_151 {

  public String reverseWords(String s) {
    s = s.trim();
    StringBuilder stringBuilder = new StringBuilder();
    String[] strings = s.split("\\s+");
    for (int i = strings.length - 1; i > -1; i--) {
      stringBuilder.append(strings[i]).append(" ");
    }
    return stringBuilder.toString().trim();
  }


  @Test
  public void test(){
    System.out.println(reverseWords("  hello world  "));
  }
}
