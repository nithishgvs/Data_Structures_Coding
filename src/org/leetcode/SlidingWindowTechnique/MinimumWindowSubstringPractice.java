package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MinimumWindowSubstringPractice {


  public String minWindow(String s, String t) {
    String currentString = new String();

    Map<Character, Integer> requiredCharsMap = populateFreqsMap(t);

    int start = 0, end = 0;

    Map<Character, Integer> currentCharsMap = new HashMap<>();

    while (end < s.length()) {

      char ch = s.charAt(end);
      populateCurrentCharsMap(ch, currentCharsMap);

      while (charsFreqsMatch(currentCharsMap, requiredCharsMap)) {
        String presentString = s.substring(start, end + 1);
        if (currentString.length() == 0) {
          currentString = presentString;
        } else if (presentString.length() < currentString.length()) {
          currentString = presentString;
        }
        char startChar = s.charAt(start);
        currentCharsMap.put(
            startChar, currentCharsMap.get(startChar) - 1);
        start++;
      }

      end++;
    }
    return currentString;
  }

  private boolean charsFreqsMatch(Map<Character, Integer> currentCharsMap,
      Map<Character, Integer> requiredCharsMap) {
    for (Map.Entry<Character, Integer> reqsEntry : requiredCharsMap.entrySet()) {
      if (currentCharsMap.containsKey(reqsEntry.getKey())
          && currentCharsMap.get(reqsEntry.getKey()) >= reqsEntry.getValue()) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }

  private void populateCurrentCharsMap(char ch, Map<Character, Integer> map) {

    int freq = map.getOrDefault(ch, 0);

    map.put(ch, freq + 1);

  }

  private Map<Character, Integer> populateFreqsMap(String pattern) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      int freq = map.getOrDefault(ch, 0);
      map.put(ch, freq + 1);

    }
    return map;
  }


  @Test
  public void test1() {
    //System.out.println(minWindow("ADDAOBECODEBANC", "ABC"));
   // System.out.println(minWindow("azjskfzts", "sz"));
    System.out.println(minWindow("ADDAOBECODEBANC", "ABC"));
  }


}
