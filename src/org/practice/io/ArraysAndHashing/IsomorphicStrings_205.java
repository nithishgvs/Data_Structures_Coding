package org.practice.io.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class IsomorphicStrings_205 {

  public boolean isIsomorphic(String s, String t) {
    return prepareString(s).equals(prepareString(t));
  }

  private String prepareString(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), i);
      }
      stringBuilder.append(map.get(s.charAt(i))).append("#");
    }

    return stringBuilder.toString();
  }


  @Test
  public void test1() {
    System.out.println(isIsomorphic("paper", "title"));
    System.out.println(isIsomorphic("13", "42"));
  }

}
