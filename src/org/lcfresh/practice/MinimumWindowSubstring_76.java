package org.lcfresh.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MinimumWindowSubstring_76 {

  public String minWindow(String s, String t) {
    String minWindow = "";

    int start = 0;
    int end = 0;

    Map<Character, Integer> tMap = generateHashMap(t);

    Map<Character, Integer> sMap = new HashMap<>();

    while (end < s.length()) {

      Character character = s.charAt(end);

      sMap.put(character, sMap.getOrDefault(character, 0) + 1);

      while (bothMapsMatch(tMap, sMap)) {
        String minString = s.substring(start, end + 1);
        if (minWindow.length() == 0) {
          minWindow = minString;
        } else if (minString.length() <= minWindow.length()) {
          minWindow = minString;
        }
        char startChar = s.charAt(start);
        Integer freq = sMap.get(startChar);
        freq--;
        if (freq == 0) {
          sMap.remove(startChar);
        } else {
          sMap.put(startChar, freq);
        }
        start++;
      }

      end++;

    }

    return minWindow;

  }

  private boolean bothMapsMatch(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {

    for (Character character : tMap.keySet()) {
      if (sMap.getOrDefault(character, 0) < tMap.get(character)) {
        return false;
      }
    }

    return true;
  }

  private Map<Character, Integer> generateHashMap(String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (int j = 0; j < t.length(); j++) {
      char ch = t.charAt(j);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    return map;
  }


  @Test
  public void test1() {
    System.out.println(minWindow("a", "aa"));
  }

}
