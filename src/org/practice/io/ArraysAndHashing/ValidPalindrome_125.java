package org.practice.io.ArraysAndHashing;

import org.junit.Test;

public class ValidPalindrome_125 {

  public boolean isPalindrome(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    s = s.toLowerCase();
    for (char ch : s.toCharArray()) {
      if (((int) ch >= 97 && (int) ch <= 122) || ((int) ch >= 48 && (int) ch <= 57)) {
        stringBuilder.append(ch);
      }
    }
    return stringBuilder.toString().equals(stringBuilder.reverse().toString());
  }


  @Test
  public void test1() {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("0P"));
  }
}
