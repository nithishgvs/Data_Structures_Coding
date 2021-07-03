package org.lcfresh.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters_3 {

  public int lengthOfLongestSubstring(String s) {
    int length = 0;

    int start = 0, end = s.length() - 1;
    int begin = 0;

    Map<Character, Integer> helperMap = new HashMap<>();
    while (start <= end) {

      char character = s.charAt(start);
      helperMap.put(character, helperMap.getOrDefault(character, 0) + 1);

      while (!checkCondition(helperMap)) {
        char removeCharacter = s.charAt(begin);
        begin++;
        int value = helperMap.get(removeCharacter) - 1;
        if (value == 0) {
          helperMap.remove(removeCharacter);
        } else {
          helperMap.put(removeCharacter, value);
        }
      }
      length = Math.max(start - begin + 1, length);
      start++;


    }

    return length;

  }

  private boolean checkCondition(Map<Character, Integer> helperMap) {
    for (Integer value : helperMap.values()) {
      if (value > 1) {
        return false;
      }
    }
    return true;
  }


  @Test
  public void test1() {
    System.out.println(lengthOfLongestSubstring("wslznzfxojzd"));
  }

}
