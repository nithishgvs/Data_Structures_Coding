package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestSubstringwithAtMostTwoDistinctCharacters_159 {


  public int lengthOfLongestSubstringTwoDistinct(String s) {

    int maxLength = 0;

    Map<Character, Integer> charMap = new HashMap<>();

    int start = 0, end = 0;

    while (end < s.length()) {

      manipulateMap(charMap, s.charAt(end), true);
      if (charMap.size() == 2) {
        maxLength = Math.max(end - start + 1, maxLength);
      } else if (charMap.size() > 2) {
        manipulateMap(charMap, s.charAt(start), false);
        start++;
      }

      end++;
    }

    return end - start == s.length() ? s.length() : maxLength;

  }

  private void manipulateMap(Map<Character, Integer> charMap, char s, boolean increment) {
    int freq = charMap.getOrDefault(s, 0);
    if (increment) {
      charMap.put(s, ++freq);
    } else {
      if (freq > 1) {
        charMap.put(s, --freq);
      } else {
        charMap.remove(s);
      }
    }

  }

  @Test
  public void test1() {
    System.out.println(lengthOfLongestSubstringTwoDistinct("aa"));
  }

}
