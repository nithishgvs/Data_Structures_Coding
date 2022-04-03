package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters_3 {


  public int lengthOfLongestSubstring(String s) {

    int maxLength = 0;

    Map<Character, Integer> map = new HashMap<>();

    int start = 0;
    int begin = 0;

    while (start < s.length()) {

      char ch = s.charAt(start);

      Integer value = map.getOrDefault(ch, 0);
      map.put(ch, ++value);

      while (!singleFreqCheck(map)) {
        char removeChar = s.charAt(begin);
        map.put(removeChar, map.get(removeChar) - 1);
        begin++;
      }

      maxLength = Math.max(maxLength, start - begin + 1);
      start++;

    }

    return maxLength;
  }

  private boolean singleFreqCheck(Map<Character, Integer> map) {

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        return false;
      }
    }

    return true;
  }


  @Test
  public void test() {
    lengthOfLongestSubstring("bbbbb");
  }


}
