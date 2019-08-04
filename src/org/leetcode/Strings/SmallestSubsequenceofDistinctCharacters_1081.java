package org.leetcode.Strings;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class SmallestSubsequenceofDistinctCharacters_1081 {

  public String smallestSubsequence(String text) {

    Map<Character, Object> map = new LinkedHashMap<>();

    char ch = '{';

    for (char c : text.toCharArray()) {
      if (map.containsKey(c)) {
        if ((int) c > (int) ch) {
          map.remove(c);
          map.put(c, null);
        }
      } else {
        map.put(c, null);
        if ((int) ch > (int) c) {
          ch = c;
        }
      }

    }

    StringBuilder sb = new StringBuilder();

    if (map.size() > 1) {
      map.keySet().forEach(character -> sb.append(character));
    }

    return sb.toString();
  }

  @Test
  public void test1() {
    //"cdadabcc"
    System.out.println(smallestSubsequence("leetcode"));
    //System.out.println(smallestSubsequence("ecbacba"));
  }

}
