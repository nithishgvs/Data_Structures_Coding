package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestPalindrome_409 {

  public int longestPalindrome(String s) {
    int count = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (char ch : s.toCharArray()) {
      if (!map.containsKey(ch)) {
        map.put(ch, 0);
      }
      map.put(ch, map.get(ch) + 1);

      if (map.get(ch) % 2 == 0) {
        count = count + 2;
        map.remove(ch);
      }
    }

    if (map.keySet().size() > 0) {
      count++;
    }

    return count;

  }


  @Test
  public void test() {
    System.out.println(longestPalindrome("abccccdd"));
  }

}
