package org.leetcode.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique_1647 {

  public int minDeletions(String s) {
    int min = 0;
    Map<Character, Integer> map = new HashMap();
    for (Character character : s.toCharArray()) {
      Integer value = map.getOrDefault(character, 0) + 1;
      map.put(character, value);
    }

    List<Integer> valuesList = new ArrayList<>(map.values());

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < valuesList.size(); i++) {
      int value = valuesList.get(i);
      while (set.contains(value)) {
        value--;
        min++;
      }
      if (value != 0) {
        set.add(value);
      }
    }

    return min;
  }


  @Test
  public void test() {
    System.out.println(minDeletions("ceabaacb"));
    System.out.println(minDeletions("aaabbbcc"));
    System.out.println(minDeletions("aab"));
  }

}
