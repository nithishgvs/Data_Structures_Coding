package org.lcfresh.practice;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class LongestPalindrome_409 {

  public int longestPalindrome(String s) {
    int length = 0;

    Set<Character> helperSet = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      if (helperSet.contains(s.charAt(i))) {
        length++;
        helperSet.remove(s.charAt(i));
      } else {
        helperSet.add(s.charAt(i));
      }
    }

    length = length * 2;

    if (!helperSet.isEmpty()) {
      length++;
    }

    return length;
  }

  @Test
  public void test1() {
    System.out.println(longestPalindrome("abccccdd"));
  }


}
