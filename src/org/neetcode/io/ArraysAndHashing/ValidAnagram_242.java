package org.neetcode.io.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ValidAnagram_242 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      int freq = map.getOrDefault(c, 0);
      map.put(c, ++freq);
    }
    for (Character c : t.toCharArray()) {
      int value = map.getOrDefault(c, 0);
      if (value >= 1) {
        if (value == 1) {
          map.remove(c);
        } else {
          map.put(c, --value);
        }
      } else {
        break;
      }
    }
    return map.isEmpty();
  }

  @Test
  public void test() {
    //System.out.println(isAnagram("anagram","nagaram"));
    System.out.println(isAnagram("a", "ab"));
  }


}
