package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MinimumNumberofStepstoMakeTwoStringsAnagram_1347 {


  public int minSteps(String s, String t) {
    int minSteps = 0;

    Map<Character, Integer> hashMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      Integer value = hashMap.getOrDefault(c, 0) + 1;
      hashMap.put(c, value);
    }

    for (char c : t.toCharArray()) {
      if (hashMap.containsKey(c)) {
        hashMap.put(c, hashMap.get(c) - 1);
      } else {
        hashMap.put(c, -1);
      }
    }

    for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
      if (entry.getValue() < 0) {
        minSteps += (entry.getValue() * -1);
      }
    }

    return minSteps;


  }

  private void populateMap(Map<Character, Integer> sMap, String s) {

    for (char c : s.toCharArray()) {
      Integer value = sMap.getOrDefault(c, 0) + 1;
      sMap.put(c, value);
    }
  }

  @Test
  public void test1() {
    System.out.println(minSteps("leetcode", "practice"));
  }

}
