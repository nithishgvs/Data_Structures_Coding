package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets_916 {

  public List<String> wordSubsets(String[] A, String[] B) {
    List<String> result = new ArrayList<>();

    Map<Character, Integer> bMap = new HashMap<>();

    for (String b : B) {
      buildBMainMap(b, bMap);
    }

    for (String a : A) {
      Map<Character, Integer> aMap = new HashMap<>();
      buildBMap(a, aMap);
      if (mapsCheck(bMap, aMap)) {
        result.add(a);
      }

    }
    return result;

  }

  private void buildBMainMap(String b, Map<Character, Integer> bMap) {
    Map<Character, Integer> subMap = new HashMap<>();
    for (char ch : b.toCharArray()) {
      Integer value = subMap.getOrDefault(ch, 0);
      subMap.put(ch, value + 1);
    }

    subMap.forEach((k, v) -> {
      if (bMap.getOrDefault(k, 0) < v || !bMap.containsKey(k)) {
        bMap.put(k, v);
      }
    });
  }

  private boolean mapsCheck(Map<Character, Integer> bMap, Map<Character, Integer> aMap) {
    for (Map.Entry<Character, Integer> bEntry : bMap.entrySet()) {
      if (aMap.get(bEntry.getKey()) == null || aMap.get(bEntry.getKey()) < bEntry.getValue()) {
        return false;
      }
    }

    return true;
  }

  private void buildBMap(String b, Map<Character, Integer> bMap) {
    for (char ch : b.toCharArray()) {
      Integer value = bMap.getOrDefault(ch, 0);
      bMap.put(ch, value + 1);

    }
  }

}
