package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MinimumWindowSubstring_76 {


  public String minWindow(String s, String t) {

    String minWindow = "";

    Map<Character, Integer> reqCharsMap = buildReqsCharsMap(t);

    Map<Character, Integer> windowCharacterMapping = new HashMap<>();

    int totalFreqsNeeded = reqCharsMap.size();

    int minWindowSoFar = Integer.MAX_VALUE;

    int start = 0, end = 0;

    int charFreqsToMatch = 0;

    while (end < s.length()) {

      char ch = s.charAt(end);

      addCharToTableMapping(windowCharacterMapping, ch);

      if (reqCharsMap.containsKey(ch)) {
        boolean freqConditionMet =
            windowCharacterMapping.get(ch).intValue() == reqCharsMap.get(ch).intValue();
        if (freqConditionMet) {
          charFreqsToMatch++;
        }
      }

      while (charFreqsToMatch == totalFreqsNeeded && start <= end) {
        char character = s.charAt(start);

        int windowSize = end - start + 1;

        if (windowSize < minWindowSoFar) {
          minWindowSoFar = windowSize;
          minWindow = s.substring(start, end + 1);
        }

        windowCharacterMapping.put(character, windowCharacterMapping.get(character) - 1);

        if (reqCharsMap.containsKey(character)) {

          boolean leftFailureCondition =
              windowCharacterMapping.get(character).intValue() < reqCharsMap.get(character)
                  .intValue();

          if (leftFailureCondition) {
            charFreqsToMatch--;
          }


        }
        start++;
      }

      end++;

    }

    return minWindow;
  }

  private void addCharToTableMapping(Map<Character, Integer> windowCharacterMapping, char ch) {
    int occurences = windowCharacterMapping.getOrDefault(ch, 0);
    windowCharacterMapping.put(ch, occurences + 1);
  }

  private Map<Character, Integer> buildReqsCharsMap(String t) {

    Map<Character, Integer> reqCharsMap = new HashMap<>();

    for (char ch : t.toCharArray()) {
      if (!reqCharsMap.containsKey(ch)) {
        reqCharsMap.putIfAbsent(ch, 0);
      }
      reqCharsMap.put(ch, reqCharsMap.get(ch) + 1);
    }

    return reqCharsMap;
  }


  @Test
  public void test1() {
    //System.out.println(minWindow("ADOBECCODEBANC", "ABCC"));
    System.out.println(minWindow("ADDAOBECODEBANC", "ABC"));
    //System.out.println(minWindow("BDAB", "AB"));

    //System.out.println(minWindow("AA", "AA"));

    //System.out.println(minWindow("ABC", "CBA"));
  }


}
