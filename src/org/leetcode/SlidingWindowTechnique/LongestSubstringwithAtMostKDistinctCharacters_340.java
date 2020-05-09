package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestSubstringwithAtMostKDistinctCharacters_340 {

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int maxLength = 0;

    Map<Character, Integer> charMap = new HashMap<>();

    int start = 0, end = 0;

    while (end < s.length()) {

      manipulateMap(charMap, s.charAt(end), true);
      if (charMap.size() <= k) {
        maxLength = Math.max(end - start + 1, maxLength);
      } else  {
        manipulateMap(charMap, s.charAt(start), false);
        start++;
      }

      end++;
    }

    return  maxLength;

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
    System.out.println(lengthOfLongestSubstringKDistinct("eceba",2));
    //System.out.println(lengthOfLongestSubstringKDistinct("aa",1));
  }
}
