package org.lcfresh.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class IsomorphicStrings_205 {

  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> mapS = new HashMap<>();
    Map<Character, Character> mapT = new HashMap<>();

    for (int i = 0; i < t.length(); i++) {
      mapS.putIfAbsent(s.charAt(i), t.charAt(i));
      mapT.putIfAbsent(t.charAt(i), s.charAt(i));

      if (mapS.get(s.charAt(i)) != t.charAt(i) || mapT.get(t.charAt(i)) != s.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void test1() {
    System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
  }

}
