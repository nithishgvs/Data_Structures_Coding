package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class MaximumNumberofOccurrencesofaSubstring_1297 {

  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

    int maxFreq = 0;

    Map<String, Integer> freqCount = new LinkedHashMap<>();

    Map<Character, Integer> helperMap = new HashMap<>();

    int start = 0;
    int end = 0;
    int subStartIndex = 0;

    while (end < s.length()) {
      char ch = s.charAt(end);
      populateHelperMap(ch, helperMap, true);
      if (end - start + 1 > maxSize) {
        populateHelperMap(s.charAt(start), helperMap, false);
        start++;
        subStartIndex = start;
      }
      int subStringSize = end - subStartIndex + 1;
      Map<Character, Integer> helperMapClone = new HashMap<>();
      helperMapClone.putAll(helperMap);
      while (subStringSize >= minSize && subStringSize <= maxSize) {
        if (helperMap.keySet().size() <= maxLetters) {
          String subString = s.substring(subStartIndex, end + 1);
          Integer freq = freqCount.getOrDefault(subString, 0) + 1;
          freqCount.put(subString, freq);
          maxFreq = Math.max(maxFreq, freq);
        }
        populateHelperMap(s.charAt(subStartIndex), helperMap, false);
        subStartIndex++;
        subStringSize = end - subStartIndex + 1;
      }
      subStartIndex = start;
      helperMap = helperMapClone;
      end++;
    }

    return maxFreq;

  }

  private void populateHelperMap(char ch, Map<Character, Integer> helperMap, boolean addition) {
    if (addition) {
      Integer value = helperMap.getOrDefault(ch, 0) + 1;
      helperMap.put(ch, value);
    } else {
      Integer value = helperMap.get(ch);
      if (value == 1) {
        helperMap.remove(ch);
      } else {
        helperMap.put(ch, value - 1);
      }
    }
  }

  @Test
  public void test1() {
    System.out.println(maxFreq("aababcaab", 2, 3, 4));
  }

  @Test
  public void test2() {
    System.out.println(maxFreq("abcde", 2, 3, 3));
  }

  @Test
  public void test3() {
    System.out.println(maxFreq("abcabababacabcabc", 3, 3, 10));
  }
  //aaaaacbc

  @Test
  public void test4() {
    System.out.println(maxFreq("aaaaacbc", 2, 4, 6));
  }

}
