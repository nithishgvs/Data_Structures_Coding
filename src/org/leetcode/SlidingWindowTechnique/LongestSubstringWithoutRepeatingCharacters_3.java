package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {


  public int lengthOfLongestSubstring(String s) {
    int length = 0;
    int start = 0;
    int end = 0;

    Map<Character, Integer> lengthMap = new HashMap<>();

    while (end < s.length()) {
      populateMap(s.charAt(end), lengthMap);
      while (!mapCondition(lengthMap) && start < end) {
        Integer value = lengthMap.get(s.charAt(start));
        if (value == 1) {
          lengthMap.remove(s.charAt(start));
        } else {
          lengthMap.put(s.charAt(start), value - 1);
        }
        start++;
      }
      length = Math.max(length, end - start + 1);
      end++;
    }

    return length;
  }

  private boolean mapCondition(Map<Character, Integer> lengthMap) {
    for (Map.Entry<Character, Integer> entry : lengthMap.entrySet()) {
      if (entry.getValue() != 1) {
        return false;
      }
    }
    return true;

  }

  private void populateMap(char charAt, Map<Character, Integer> lengthMap) {
    Integer value = lengthMap.getOrDefault(charAt, 0);
    lengthMap.put(charAt, value + 1);
  }

}
