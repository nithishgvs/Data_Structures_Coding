package org.practice.io.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RansomNote_383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> helperMap = new HashMap<>();

    for (int i = 0; i < magazine.length(); i++) {
      if (!helperMap.containsKey(magazine.charAt(i))) {
        helperMap.put(magazine.charAt(i), 0);
      }
      helperMap.put(magazine.charAt(i), helperMap.get(magazine.charAt(i)) + 1);
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      final char character = ransomNote.charAt(i);
      if (!helperMap.containsKey(character)) {
        return false;
      }

      if (helperMap.get(character) > 1) {
        helperMap.put(character, helperMap.get(character) - 1);
      } else {
        helperMap.remove(character);
      }
    }

    return true;

  }

  @Test
  public void test1() {
    System.out.println(canConstruct("aa", "aab"));
  }

}
