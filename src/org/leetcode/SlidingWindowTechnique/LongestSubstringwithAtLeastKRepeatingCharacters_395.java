package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestSubstringwithAtLeastKRepeatingCharacters_395 {


  public int longestSubstring(String s, int k) {
    int length = 0;

    int start = 0;
    int end = s.length();

    Map<Character, Integer> frequencyMap = new HashMap<>();

    while (start < end) {
      char ch = s.charAt(start);
      updateFrequencyMap(ch, frequencyMap);
      if (frequencyMapConditon(frequencyMap, k)) {
        length = Math.max(length, start + 1);
      } else {
        int subStart = 0;
        Map<Character, Integer> frequencyMapClone = new HashMap<>();
        frequencyMapClone.putAll(frequencyMap);
        while (subStart < start && s.substring(subStart, start + 1).length() >= k) {
          char subChar = s.charAt(subStart);
          updateFrequencyMapClone(frequencyMapClone, subChar);
          if (frequencyMapConditon(frequencyMapClone, k)) {
            length = Math.max(length, start - subStart);
            break;
          }
          subStart++;
        }
      }
      start++;
    }

    return length;
  }

  private void updateFrequencyMapClone(Map<Character, Integer> frequencyMapClone, char subChar) {
    Integer value = frequencyMapClone.get(subChar);
    if (value == 1) {
      frequencyMapClone.remove(subChar);
    } else {
      frequencyMapClone.put(subChar, value - 1);
    }
  }

  private boolean frequencyMapConditon(Map<Character, Integer> frequencyMap, int k) {
    for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
      if (entry.getValue() < k) {
        return false;
      }
    }
    return true;
  }

  private void updateFrequencyMap(char ch, Map<Character, Integer> frequencyMap) {
    Integer value = frequencyMap.getOrDefault(ch, 0);
    frequencyMap.put(ch, value + 1);
  }


  @Test
  public void test1() {
    System.out.println(longestSubstring("ababbc", 2));
  }//"bbaaacbd""aacbbbdc"

  @Test
  public void test2() {
    //System.out.println(longestSubstring("aacbbbdc", 2));
    //System.out.println(longestSubstring("ababacb", 3));
    System.out.println(longestSubstring("hadccccccddddcccccddddddccccccccdddddddeeffgglhkj", 7));

  }


}
